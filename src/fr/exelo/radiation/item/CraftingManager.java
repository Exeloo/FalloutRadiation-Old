package fr.exelo.radiation.item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftingManager{
	
	public CraftingManager(JavaPlugin plugin) {
        
	        NamespacedKey key11 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T45H");
	        NamespacedKey key12 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T45C");
	        NamespacedKey key13 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T45L");
	        NamespacedKey key14 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T45B");
	        NamespacedKey key21 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T51bH");
	        NamespacedKey key22 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T51bC");
	        NamespacedKey key23 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T51bL");
	        NamespacedKey key24 = new NamespacedKey(plugin, plugin.getDescription().getName() + "T51bB");
	        NamespacedKey key31 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X01H");
	        NamespacedKey key32 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X01C");
	        NamespacedKey key33 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X01L");
	        NamespacedKey key34 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X01B");
	        NamespacedKey key41 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X02H");
	        NamespacedKey key42 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X02C");
	        NamespacedKey key43 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X02L");
	        NamespacedKey key44 = new NamespacedKey(plugin, plugin.getDescription().getName() + "X02B");
	        NamespacedKey key5 = new NamespacedKey(plugin, plugin.getDescription().getName() + "Per3000");
	        NamespacedKey key6 = new NamespacedKey(plugin, plugin.getDescription().getName() + "Per4000");
	        
			ShapedRecipe T45HRecipe = new ShapedRecipe(key11, Items.T45_Helmet);
	        T45HRecipe.shape("LGL", "GAG", "LGL");
	        T45HRecipe.setIngredient('L', Material.LEATHER);
	        T45HRecipe.setIngredient('G', Material.GOLD_BLOCK);
	        T45HRecipe.setIngredient('A', Material.LEATHER_HELMET);
	        Bukkit.addRecipe(T45HRecipe);
	        
	        ShapedRecipe T45CRecipe = new ShapedRecipe(key12, Items.T45_Chestplate);
	        T45CRecipe.shape("LGL", "GAG", "LGL");
	        T45CRecipe.setIngredient('L', Material.LEATHER);
	        T45CRecipe.setIngredient('G', Material.GOLD_BLOCK);
	        T45CRecipe.setIngredient('A', Material.LEATHER_CHESTPLATE);
	        Bukkit.addRecipe(T45CRecipe);
	
	        ShapedRecipe T45LRecipe = new ShapedRecipe(key13, Items.T45_Leggings);
	        T45LRecipe.shape("LGL", "GAG", "LGL");
	        T45LRecipe.setIngredient('L', Material.LEATHER);
	        T45LRecipe.setIngredient('G', Material.GOLD_BLOCK);
	        T45LRecipe.setIngredient('A', Material.LEATHER_LEGGINGS);
	        Bukkit.addRecipe(T45LRecipe);
	
	        ShapedRecipe T45BRecipe = new ShapedRecipe(key14, Items.T45_Boots);
	        T45BRecipe.shape("LGL", "GAG", "LGL");
	        T45BRecipe.setIngredient('L', Material.LEATHER);
	        T45BRecipe.setIngredient('G', Material.GOLD_BLOCK);
	        T45BRecipe.setIngredient('A', Material.LEATHER_BOOTS);
	        Bukkit.addRecipe(T45BRecipe);
	
	        ShapedRecipe T51bHRecipe = new ShapedRecipe(key21, Items.T51_Helmet);
	        T51bHRecipe.shape("III", "IAI", "III");
	        T51bHRecipe.setIngredient('A', Items.T45_Helmet.getData());
	        T51bHRecipe.setIngredient('I', Material.IRON_BLOCK);
	        Bukkit.addRecipe(T51bHRecipe);
	
	        ShapedRecipe T51bCRecipe = new ShapedRecipe(key22, Items.T51_Chestplate);
	        T51bCRecipe.shape("III", "IAI", "III");
	        T51bCRecipe.setIngredient('A', Items.T45_Chestplate.getData());
	        T51bCRecipe.setIngredient('I', Material.IRON_BLOCK);
	        Bukkit.addRecipe(T51bCRecipe);
	
	        ShapedRecipe T51bLRecipe = new ShapedRecipe(key23, Items.T51_Leggings);
	        T51bLRecipe.shape("III", "IAI", "III");
	        T51bLRecipe.setIngredient('A', Items.T45_Leggings.getData());
	        T51bLRecipe.setIngredient('I', Material.IRON_BLOCK);
	        Bukkit.addRecipe(T51bLRecipe);
	
	        ShapedRecipe T51bBRecipe = new ShapedRecipe(key24, Items.T51_Boots);
	        T51bBRecipe.shape("III", "IAI", "III");
	        T51bBRecipe.setIngredient('A', Items.T45_Boots.getData());
	        T51bBRecipe.setIngredient('I', Material.IRON_BLOCK);
	        Bukkit.addRecipe(T51bBRecipe);
	
	        ShapedRecipe X01HRecipe = new ShapedRecipe(key31, Items.X01_Helmet);
	        X01HRecipe.shape("DOD", "DAD", "DOD");
	        X01HRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
	        X01HRecipe.setIngredient('O', Material.TURTLE_HELMET);
	        X01HRecipe.setIngredient('A', Items.T51_Helmet.getData());
	        Bukkit.addRecipe(X01HRecipe);
	
	        ShapedRecipe X01CRecipe = new ShapedRecipe(key32, Items.X01_Chestplate);
	        X01CRecipe.shape("DOD", "DAD", "DOD");
	        X01CRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
	        X01CRecipe.setIngredient('O', Material.TOTEM_OF_UNDYING);
	        X01CRecipe.setIngredient('A', Items.T51_Chestplate.getData());
	        Bukkit.addRecipe(X01CRecipe);
	
	        ShapedRecipe X01LRecipe = new ShapedRecipe(key33, Items.X01_Leggings);
	        X01LRecipe.shape("DOD", "DAD", "DOD");
	        X01LRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
	        X01LRecipe.setIngredient('O', Material.PHANTOM_MEMBRANE);
	        X01LRecipe.setIngredient('A', Items.T51_Leggings.getData());
	        Bukkit.addRecipe(X01LRecipe);
	
	        ShapedRecipe X01BRecipe = new ShapedRecipe(key34, Items.X01_Boots);
	        X01BRecipe.shape("DOD", "DAD", "DOD");
	        X01BRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
	        X01BRecipe.setIngredient('O', Material.SHULKER_SHELL);
	        X01BRecipe.setIngredient('A', Items.T51_Boots.getData());
	        Bukkit.addRecipe(X01BRecipe);
	
	        ShapedRecipe X02HRecipe = new ShapedRecipe(key41, Items.X02_Helmet);
	        X02HRecipe.shape(" O ", "NAN", " N ");
	        X02HRecipe.setIngredient('O', Material.CONDUIT);
	        X02HRecipe.setIngredient('A', Items.X01_Helmet.getData());
	        X02HRecipe.setIngredient('N', Material.NETHERITE_BLOCK);
	        Bukkit.addRecipe(X02HRecipe);
	
	        ShapedRecipe X02CRecipe = new ShapedRecipe(key42, Items.X02_Chestplate);
	        X02CRecipe.shape(" O ", "NAN", " N ");
	        X02CRecipe.setIngredient('O', Material.DRAGON_EGG);
	        X02CRecipe.setIngredient('A', Items.X01_Chestplate.getData());
	        X02CRecipe.setIngredient('N', Material.NETHERITE_BLOCK);
	        Bukkit.addRecipe(X02CRecipe);
	
	        ShapedRecipe X02LRecipe = new ShapedRecipe(key43, Items.X02_Leggings);
	        X02LRecipe.shape(" O ", "NAN", " N ");
	        X02LRecipe.setIngredient('O', Material.ELYTRA);
	        X02LRecipe.setIngredient('A', Items.X01_Leggings.getData());
	        X02LRecipe.setIngredient('N', Material.NETHERITE_BLOCK);
	        Bukkit.addRecipe(X02LRecipe);
	
	        ShapedRecipe X02BRecipe = new ShapedRecipe(key44, Items.X02_Boots);
	        X02BRecipe.shape(" O ", "NAN", " N ");
	        X02BRecipe.setIngredient('O', Material.BEACON);
	        X02BRecipe.setIngredient('A', Items.X01_Boots.getData());
	        X02BRecipe.setIngredient('N', Material.NETHERITE_BLOCK);
	        Bukkit.addRecipe(X02BRecipe);
	
	        ShapedRecipe Per3000Recipe = new ShapedRecipe(key5, Items.Pickaxe3);
	        Per3000Recipe.shape("EEE", " D ", " D ");
	        Per3000Recipe.setIngredient('E', Material.EMERALD_BLOCK);
	        Per3000Recipe.setIngredient('D', Material.DIAMOND_BLOCK);
	        Bukkit.addRecipe(Per3000Recipe);
	
	        ShapedRecipe Per4000Recipe = new ShapedRecipe(key6, Items.Pickaxe4);
	        Per4000Recipe.shape("NNN", " P ", " N ");
	        Per4000Recipe.setIngredient('N', Material.NETHERITE_BLOCK);
	        Per4000Recipe.setIngredient('P', Items.Pickaxe3.getData());
	        Bukkit.addRecipe(Per4000Recipe);
	}

        
 


    public static void craft(Event event) {
        if (((PrepareItemCraftEvent) event).getRecipe() == null) {
            return;}
        if (!isCorrectResult(((PrepareItemCraftEvent) event).getRecipe().getResult())) {
            return;}
        ItemStack[] items = ((PrepareItemCraftEvent) event).getInventory().getMatrix();
        if (!(items[4].getItemMeta().getDisplayName().equals(Items.Pickaxe3.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T45_Helmet.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T45_Chestplate.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T45_Leggings.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T45_Boots.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T51_Helmet.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T51_Chestplate.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T51_Leggings.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.T51_Boots.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.X01_Helmet.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.X01_Chestplate.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.X01_Leggings.getItemMeta().getDisplayName()) || 
        		items[4].getItemMeta().getDisplayName().equals(Items.X01_Boots.getItemMeta().getDisplayName()))) {
            ((PrepareItemCraftEvent) event).getInventory().setResult(null);}
    }


    private static boolean isCorrectResult(ItemStack item) {
        return (item.isSimilar(Items.Pickaxe4) || 
        		item.isSimilar(Items.T51_Helmet) || item.isSimilar(Items.T51_Chestplate) || item.isSimilar(Items.T51_Leggings) || item.isSimilar(Items.T51_Boots) || 
        		item.isSimilar(Items.X01_Helmet) || item.isSimilar(Items.X01_Chestplate) || item.isSimilar(Items.X01_Leggings) || item.isSimilar(Items.X01_Boots) || 
        		item.isSimilar(Items.X02_Helmet) || item.isSimilar(Items.X02_Chestplate) || item.isSimilar(Items.X02_Leggings) || item.isSimilar(Items.X02_Boots));
    }

}

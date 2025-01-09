package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuoptionsdata extends GXProcedure
{
   public menuoptionsdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuoptionsdata.class ), "" );
   }

   public menuoptionsdata( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( )
   {
      menuoptionsdata.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      menuoptionsdata.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV5id = (short)(0) ;
      Gxm1dvelop_menu = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("web.home", new String[] {}, new String[] {})  );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "WWP_HomeTitle", "") );
      Gxm1dvelop_menu = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1.1" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1.2" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1.3" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "Opción de Menú 2.1", "") );
      Gxm4dvelop_menu_subitems_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "Opción de Menú 2.1.1", "") );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm4dvelop_menu_subitems_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "Opción de Menú 2.1.2", "") );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm4dvelop_menu_subitems_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "Opción de Menú 2.1.3", "") );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "Opción de Menú 2.2", "") );
      Gxm4dvelop_menu_subitems_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "Opción de Menú 2.2.1", "") );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 3" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Menú de Desarrollo" );
      Gxv5skipcount = 0 ;
      AV15GXV2 = 1 ;
      GXt_objcol_SdtProgramNames_ProgramName1 = AV14GXV1 ;
      GXv_objcol_SdtProgramNames_ProgramName2[0] = GXt_objcol_SdtProgramNames_ProgramName1 ;
      new web.wwpbaseobjects.listwwpprograms(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName2) ;
      GXt_objcol_SdtProgramNames_ProgramName1 = GXv_objcol_SdtProgramNames_ProgramName2[0] ;
      AV14GXV1 = GXt_objcol_SdtProgramNames_ProgramName1 ;
      while ( AV15GXV2 <= AV14GXV1.size() )
      {
         AV6ProgramName = (web.wwpbaseobjects.SdtProgramNames_ProgramName)((web.wwpbaseobjects.SdtProgramNames_ProgramName)AV14GXV1.elementAt(-1+AV15GXV2));
         Gxv5skipcount = (int)(Gxv5skipcount+1) ;
         Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
         if ( ( 20 != 0 ) && ( Gxv5skipcount >= 20 ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         AV15GXV2 = (int)(AV15GXV2+1) ;
      }
      Gxm1dvelop_menu = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "Security of the application", "") );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-key" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Security" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "Users", "") );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("web.wwpbaseobjects.secuserww", new String[] {}, new String[] {"MenuOpcCod"})  );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Users" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "Roles", "") );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("web.wwpbaseobjects.secroleww", new String[] {}, new String[] {})  );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Roles" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (web.wwpbaseobjects.SdtDVelop_Menu_Item)new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("web.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {})  );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Functionalities" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = menuoptionsdata.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>(web.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "PayDay", remoteHandle);
      Gxm1dvelop_menu = new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems = new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm4dvelop_menu_subitems_subitems = new web.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV14GXV1 = new GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>(web.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "PayDay", remoteHandle);
      GXt_objcol_SdtProgramNames_ProgramName1 = new GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>(web.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "PayDay", remoteHandle);
      GXv_objcol_SdtProgramNames_ProgramName2 = new GXBaseCollection[1] ;
      AV6ProgramName = new web.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV5id ;
   private short Gx_err ;
   private int Gxv5skipcount ;
   private int AV15GXV2 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName> AV14GXV1 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName> GXt_objcol_SdtProgramNames_ProgramName1 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName> GXv_objcol_SdtProgramNames_ProgramName2[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> Gxm2rootcol ;
   private web.wwpbaseobjects.SdtProgramNames_ProgramName AV6ProgramName ;
   private web.wwpbaseobjects.SdtDVelop_Menu_Item Gxm1dvelop_menu ;
   private web.wwpbaseobjects.SdtDVelop_Menu_Item Gxm3dvelop_menu_subitems ;
   private web.wwpbaseobjects.SdtDVelop_Menu_Item Gxm4dvelop_menu_subitems_subitems ;
}


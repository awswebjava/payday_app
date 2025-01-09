package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuitemwwgetfilterdata extends GXProcedure
{
   public menuitemwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitemwwgetfilterdata.class ), "" );
   }

   public menuitemwwgetfilterdata( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      menuitemwwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      menuitemwwgetfilterdata.this.AV30DDOName = aP0;
      menuitemwwgetfilterdata.this.AV31SearchTxt = aP1;
      menuitemwwgetfilterdata.this.AV32SearchTxtTo = aP2;
      menuitemwwgetfilterdata.this.aP3 = aP3;
      menuitemwwgetfilterdata.this.aP4 = aP4;
      menuitemwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV37EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      menuitemwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      menuitemwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem", GXv_boolean6) ;
      menuitemwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MENUITEMID") == 0 )
         {
            /* Execute user subroutine: 'LOADMENUITEMIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MENUITEMTITULO") == 0 )
         {
            /* Execute user subroutine: 'LOADMENUITEMTITULOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MITEMPADREDEF") == 0 )
         {
            /* Execute user subroutine: 'LOADMITEMPADREDEFOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MITEMICOSVG") == 0 )
         {
            /* Execute user subroutine: 'LOADMITEMICOSVGOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MITEMBIENTITDEF") == 0 )
         {
            /* Execute user subroutine: 'LOADMITEMBIENTITDEFOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MITEMBIENTEXTDEF") == 0 )
         {
            /* Execute user subroutine: 'LOADMITEMBIENTEXTDEFOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_MITEMHELP") == 0 )
         {
            /* Execute user subroutine: 'LOADMITEMHELPOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV20Options.toJSonString(false) ;
      AV34OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV35OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25Session.getValue("MenuItemWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MenuItemWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("MenuItemWWGridState"), null, null);
      }
      AV60GXV1 = 1 ;
      while ( AV60GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV60GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILID") == 0 )
         {
            AV39TFPerfilId = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFPerfilId_To = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMID") == 0 )
         {
            AV12TFMenuItemId = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMID_SEL") == 0 )
         {
            AV11TFMenuItemId_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFMenuItemId_Sels.fromJSonString(AV11TFMenuItemId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMTITULO") == 0 )
         {
            AV15TFMenuItemTitulo = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMTITULO_SEL") == 0 )
         {
            AV14TFMenuItemTitulo_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFMenuItemTitulo_Sels.fromJSonString(AV14TFMenuItemTitulo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMESMENU_SEL") == 0 )
         {
            AV17TFMItemEsMenu_Sel = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREDEF") == 0 )
         {
            AV55TFMItemPadreDef = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREDEF_SEL") == 0 )
         {
            AV54TFMItemPadreDef_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFMItemPadreDef_Sels.fromJSonString(AV54TFMItemPadreDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREOBL_SEL") == 0 )
         {
            AV57TFMItemPadreObl_Sel = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMICOSVG") == 0 )
         {
            AV52TFMItemIcoSVG = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMICOSVG_SEL") == 0 )
         {
            AV51TFMItemIcoSVG_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFMItemIcoSVG_Sels.fromJSonString(AV51TFMItemIcoSVG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTITDEF") == 0 )
         {
            AV46TFMItemBienTitDef = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTITDEF_SEL") == 0 )
         {
            AV45TFMItemBienTitDef_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFMItemBienTitDef_Sels.fromJSonString(AV45TFMItemBienTitDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTEXTDEF") == 0 )
         {
            AV43TFMItemBienTextDef = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTEXTDEF_SEL") == 0 )
         {
            AV42TFMItemBienTextDef_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFMItemBienTextDef_Sels.fromJSonString(AV42TFMItemBienTextDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMHELP") == 0 )
         {
            AV49TFMItemHelp = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMHELP_SEL") == 0 )
         {
            AV48TFMItemHelp_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFMItemHelp_Sels.fromJSonString(AV48TFMItemHelp_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV60GXV1 = (int)(AV60GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADMENUITEMIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFMenuItemId = AV31SearchTxt ;
      AV13TFMenuItemId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1UO2 = false ;
         A1937MenuItemId = P01UO2_A1937MenuItemId[0] ;
         A1961MItemHelp = P01UO2_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P01UO2_A1956MItemBienTextDef[0] ;
         A1955MItemBienTitDef = P01UO2_A1955MItemBienTitDef[0] ;
         A1957MItemIcoSVG = P01UO2_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO2_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P01UO2_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P01UO2_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO2_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P01UO2_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P01UO2_A1939MenuItemTitulo[0] ;
         A1925PerfilId = P01UO2_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01UO2_A1937MenuItemId[0], A1937MenuItemId) == 0 ) )
         {
            brk1UO2 = false ;
            A1925PerfilId = P01UO2_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1937MenuItemId)==0) )
         {
            AV19Option = A1937MenuItemId ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO2 )
         {
            brk1UO2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMENUITEMTITULOOPTIONS' Routine */
      returnInSub = false ;
      AV15TFMenuItemTitulo = AV31SearchTxt ;
      AV16TFMenuItemTitulo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO3 */
      pr_default.execute(1, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1UO4 = false ;
         A1939MenuItemTitulo = P01UO3_A1939MenuItemTitulo[0] ;
         A1961MItemHelp = P01UO3_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P01UO3_A1956MItemBienTextDef[0] ;
         A1955MItemBienTitDef = P01UO3_A1955MItemBienTitDef[0] ;
         A1957MItemIcoSVG = P01UO3_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO3_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P01UO3_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P01UO3_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO3_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P01UO3_A1938MItemEsMenu[0] ;
         A1937MenuItemId = P01UO3_A1937MenuItemId[0] ;
         A1925PerfilId = P01UO3_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01UO3_A1939MenuItemTitulo[0], A1939MenuItemTitulo) == 0 ) )
         {
            brk1UO4 = false ;
            A1937MenuItemId = P01UO3_A1937MenuItemId[0] ;
            A1925PerfilId = P01UO3_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1939MenuItemTitulo)==0) )
         {
            AV19Option = A1939MenuItemTitulo ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO4 )
         {
            brk1UO4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMITEMPADREDEFOPTIONS' Routine */
      returnInSub = false ;
      AV55TFMItemPadreDef = AV31SearchTxt ;
      AV56TFMItemPadreDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO4 */
      pr_default.execute(2, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1UO6 = false ;
         A1944MItemPadreDef = P01UO4_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO4_n1944MItemPadreDef[0] ;
         A1961MItemHelp = P01UO4_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P01UO4_A1956MItemBienTextDef[0] ;
         A1955MItemBienTitDef = P01UO4_A1955MItemBienTitDef[0] ;
         A1957MItemIcoSVG = P01UO4_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO4_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P01UO4_A1945MItemPadreObl[0] ;
         A1938MItemEsMenu = P01UO4_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P01UO4_A1939MenuItemTitulo[0] ;
         A1937MenuItemId = P01UO4_A1937MenuItemId[0] ;
         A1925PerfilId = P01UO4_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01UO4_A1944MItemPadreDef[0], A1944MItemPadreDef) == 0 ) )
         {
            brk1UO6 = false ;
            A1937MenuItemId = P01UO4_A1937MenuItemId[0] ;
            A1925PerfilId = P01UO4_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1944MItemPadreDef)==0) )
         {
            AV19Option = A1944MItemPadreDef ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO6 )
         {
            brk1UO6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADMITEMICOSVGOPTIONS' Routine */
      returnInSub = false ;
      AV52TFMItemIcoSVG = AV31SearchTxt ;
      AV53TFMItemIcoSVG_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO5 */
      pr_default.execute(3, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk1UO8 = false ;
         A1957MItemIcoSVG = P01UO5_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO5_n1957MItemIcoSVG[0] ;
         A1961MItemHelp = P01UO5_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P01UO5_A1956MItemBienTextDef[0] ;
         A1955MItemBienTitDef = P01UO5_A1955MItemBienTitDef[0] ;
         A1945MItemPadreObl = P01UO5_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P01UO5_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO5_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P01UO5_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P01UO5_A1939MenuItemTitulo[0] ;
         A1937MenuItemId = P01UO5_A1937MenuItemId[0] ;
         A1925PerfilId = P01UO5_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P01UO5_A1957MItemIcoSVG[0], A1957MItemIcoSVG) == 0 ) )
         {
            brk1UO8 = false ;
            A1937MenuItemId = P01UO5_A1937MenuItemId[0] ;
            A1925PerfilId = P01UO5_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A1957MItemIcoSVG)==0) )
         {
            AV19Option = A1957MItemIcoSVG ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO8 )
         {
            brk1UO8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADMITEMBIENTITDEFOPTIONS' Routine */
      returnInSub = false ;
      AV46TFMItemBienTitDef = AV31SearchTxt ;
      AV47TFMItemBienTitDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO6 */
      pr_default.execute(4, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk1UO10 = false ;
         A1955MItemBienTitDef = P01UO6_A1955MItemBienTitDef[0] ;
         A1961MItemHelp = P01UO6_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P01UO6_A1956MItemBienTextDef[0] ;
         A1957MItemIcoSVG = P01UO6_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO6_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P01UO6_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P01UO6_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO6_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P01UO6_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P01UO6_A1939MenuItemTitulo[0] ;
         A1937MenuItemId = P01UO6_A1937MenuItemId[0] ;
         A1925PerfilId = P01UO6_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P01UO6_A1955MItemBienTitDef[0], A1955MItemBienTitDef) == 0 ) )
         {
            brk1UO10 = false ;
            A1937MenuItemId = P01UO6_A1937MenuItemId[0] ;
            A1925PerfilId = P01UO6_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A1955MItemBienTitDef)==0) )
         {
            AV19Option = A1955MItemBienTitDef ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO10 )
         {
            brk1UO10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADMITEMBIENTEXTDEFOPTIONS' Routine */
      returnInSub = false ;
      AV43TFMItemBienTextDef = AV31SearchTxt ;
      AV44TFMItemBienTextDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO7 */
      pr_default.execute(5, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk1UO12 = false ;
         A1956MItemBienTextDef = P01UO7_A1956MItemBienTextDef[0] ;
         A1961MItemHelp = P01UO7_A1961MItemHelp[0] ;
         A1955MItemBienTitDef = P01UO7_A1955MItemBienTitDef[0] ;
         A1957MItemIcoSVG = P01UO7_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO7_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P01UO7_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P01UO7_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO7_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P01UO7_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P01UO7_A1939MenuItemTitulo[0] ;
         A1937MenuItemId = P01UO7_A1937MenuItemId[0] ;
         A1925PerfilId = P01UO7_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P01UO7_A1956MItemBienTextDef[0], A1956MItemBienTextDef) == 0 ) )
         {
            brk1UO12 = false ;
            A1937MenuItemId = P01UO7_A1937MenuItemId[0] ;
            A1925PerfilId = P01UO7_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A1956MItemBienTextDef)==0) )
         {
            AV19Option = A1956MItemBienTextDef ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO12 )
         {
            brk1UO12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADMITEMHELPOPTIONS' Routine */
      returnInSub = false ;
      AV49TFMItemHelp = AV31SearchTxt ;
      AV50TFMItemHelp_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Menuitemwwds_1_tfperfilid = AV39TFPerfilId ;
      AV63Menuitemwwds_2_tfperfilid_to = AV40TFPerfilId_To ;
      AV64Menuitemwwds_3_tfmenuitemid = AV12TFMenuItemId ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = AV13TFMenuItemId_Sels ;
      AV66Menuitemwwds_5_tfmenuitemtitulo = AV15TFMenuItemTitulo ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = AV16TFMenuItemTitulo_Sels ;
      AV68Menuitemwwds_7_tfmitemesmenu_sel = AV17TFMItemEsMenu_Sel ;
      AV69Menuitemwwds_8_tfmitempadredef = AV55TFMItemPadreDef ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = AV56TFMItemPadreDef_Sels ;
      AV71Menuitemwwds_10_tfmitempadreobl_sel = AV57TFMItemPadreObl_Sel ;
      AV72Menuitemwwds_11_tfmitemicosvg = AV52TFMItemIcoSVG ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = AV53TFMItemIcoSVG_Sels ;
      AV74Menuitemwwds_13_tfmitembientitdef = AV46TFMItemBienTitDef ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = AV47TFMItemBienTitDef_Sels ;
      AV76Menuitemwwds_15_tfmitembientextdef = AV43TFMItemBienTextDef ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = AV44TFMItemBienTextDef_Sels ;
      AV78Menuitemwwds_17_tfmitemhelp = AV49TFMItemHelp ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = AV50TFMItemHelp_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV62Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV65Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV64Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV67Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV68Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV70Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV69Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV71Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV73Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV72Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV75Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV74Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV77Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV76Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV79Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV78Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT
                                           }
      });
      lV64Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV64Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV66Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV69Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV69Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV72Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV72Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV74Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV74Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV76Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV76Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV78Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV78Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P01UO8 */
      pr_default.execute(6, new Object[] {Byte.valueOf(AV62Menuitemwwds_1_tfperfilid), Byte.valueOf(AV63Menuitemwwds_2_tfperfilid_to), lV64Menuitemwwds_3_tfmenuitemid, lV66Menuitemwwds_5_tfmenuitemtitulo, lV69Menuitemwwds_8_tfmitempadredef, lV72Menuitemwwds_11_tfmitemicosvg, lV74Menuitemwwds_13_tfmitembientitdef, lV76Menuitemwwds_15_tfmitembientextdef, lV78Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk1UO14 = false ;
         A1961MItemHelp = P01UO8_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P01UO8_A1956MItemBienTextDef[0] ;
         A1955MItemBienTitDef = P01UO8_A1955MItemBienTitDef[0] ;
         A1957MItemIcoSVG = P01UO8_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UO8_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P01UO8_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P01UO8_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UO8_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P01UO8_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P01UO8_A1939MenuItemTitulo[0] ;
         A1937MenuItemId = P01UO8_A1937MenuItemId[0] ;
         A1925PerfilId = P01UO8_A1925PerfilId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P01UO8_A1961MItemHelp[0], A1961MItemHelp) == 0 ) )
         {
            brk1UO14 = false ;
            A1937MenuItemId = P01UO8_A1937MenuItemId[0] ;
            A1925PerfilId = P01UO8_A1925PerfilId[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1UO14 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A1961MItemHelp)==0) )
         {
            AV19Option = A1961MItemHelp ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UO14 )
         {
            brk1UO14 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   protected void cleanup( )
   {
      this.aP3[0] = menuitemwwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = menuitemwwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = menuitemwwgetfilterdata.this.AV35OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV35OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFMenuItemId = "" ;
      AV11TFMenuItemId_SelsJson = "" ;
      AV13TFMenuItemId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFMenuItemTitulo = "" ;
      AV14TFMenuItemTitulo_SelsJson = "" ;
      AV16TFMenuItemTitulo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFMItemPadreDef = "" ;
      AV54TFMItemPadreDef_SelsJson = "" ;
      AV56TFMItemPadreDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFMItemIcoSVG = "" ;
      AV51TFMItemIcoSVG_SelsJson = "" ;
      AV53TFMItemIcoSVG_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFMItemBienTitDef = "" ;
      AV45TFMItemBienTitDef_SelsJson = "" ;
      AV47TFMItemBienTitDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFMItemBienTextDef = "" ;
      AV42TFMItemBienTextDef_SelsJson = "" ;
      AV44TFMItemBienTextDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFMItemHelp = "" ;
      AV48TFMItemHelp_SelsJson = "" ;
      AV50TFMItemHelp_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      A1937MenuItemId = "" ;
      AV64Menuitemwwds_3_tfmenuitemid = "" ;
      AV65Menuitemwwds_4_tfmenuitemid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Menuitemwwds_5_tfmenuitemtitulo = "" ;
      AV67Menuitemwwds_6_tfmenuitemtitulo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Menuitemwwds_8_tfmitempadredef = "" ;
      AV70Menuitemwwds_9_tfmitempadredef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Menuitemwwds_11_tfmitemicosvg = "" ;
      AV73Menuitemwwds_12_tfmitemicosvg_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Menuitemwwds_13_tfmitembientitdef = "" ;
      AV75Menuitemwwds_14_tfmitembientitdef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Menuitemwwds_15_tfmitembientextdef = "" ;
      AV77Menuitemwwds_16_tfmitembientextdef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Menuitemwwds_17_tfmitemhelp = "" ;
      AV79Menuitemwwds_18_tfmitemhelp_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV64Menuitemwwds_3_tfmenuitemid = "" ;
      lV66Menuitemwwds_5_tfmenuitemtitulo = "" ;
      lV69Menuitemwwds_8_tfmitempadredef = "" ;
      lV72Menuitemwwds_11_tfmitemicosvg = "" ;
      lV74Menuitemwwds_13_tfmitembientitdef = "" ;
      lV76Menuitemwwds_15_tfmitembientextdef = "" ;
      lV78Menuitemwwds_17_tfmitemhelp = "" ;
      A1939MenuItemTitulo = "" ;
      A1944MItemPadreDef = "" ;
      A1957MItemIcoSVG = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      A1961MItemHelp = "" ;
      P01UO2_A1937MenuItemId = new String[] {""} ;
      P01UO2_A1961MItemHelp = new String[] {""} ;
      P01UO2_A1956MItemBienTextDef = new String[] {""} ;
      P01UO2_A1955MItemBienTitDef = new String[] {""} ;
      P01UO2_A1957MItemIcoSVG = new String[] {""} ;
      P01UO2_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO2_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO2_A1944MItemPadreDef = new String[] {""} ;
      P01UO2_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO2_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO2_A1939MenuItemTitulo = new String[] {""} ;
      P01UO2_A1925PerfilId = new byte[1] ;
      AV19Option = "" ;
      P01UO3_A1939MenuItemTitulo = new String[] {""} ;
      P01UO3_A1961MItemHelp = new String[] {""} ;
      P01UO3_A1956MItemBienTextDef = new String[] {""} ;
      P01UO3_A1955MItemBienTitDef = new String[] {""} ;
      P01UO3_A1957MItemIcoSVG = new String[] {""} ;
      P01UO3_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO3_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO3_A1944MItemPadreDef = new String[] {""} ;
      P01UO3_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO3_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO3_A1937MenuItemId = new String[] {""} ;
      P01UO3_A1925PerfilId = new byte[1] ;
      P01UO4_A1944MItemPadreDef = new String[] {""} ;
      P01UO4_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO4_A1961MItemHelp = new String[] {""} ;
      P01UO4_A1956MItemBienTextDef = new String[] {""} ;
      P01UO4_A1955MItemBienTitDef = new String[] {""} ;
      P01UO4_A1957MItemIcoSVG = new String[] {""} ;
      P01UO4_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO4_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO4_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO4_A1939MenuItemTitulo = new String[] {""} ;
      P01UO4_A1937MenuItemId = new String[] {""} ;
      P01UO4_A1925PerfilId = new byte[1] ;
      P01UO5_A1957MItemIcoSVG = new String[] {""} ;
      P01UO5_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO5_A1961MItemHelp = new String[] {""} ;
      P01UO5_A1956MItemBienTextDef = new String[] {""} ;
      P01UO5_A1955MItemBienTitDef = new String[] {""} ;
      P01UO5_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO5_A1944MItemPadreDef = new String[] {""} ;
      P01UO5_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO5_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO5_A1939MenuItemTitulo = new String[] {""} ;
      P01UO5_A1937MenuItemId = new String[] {""} ;
      P01UO5_A1925PerfilId = new byte[1] ;
      P01UO6_A1955MItemBienTitDef = new String[] {""} ;
      P01UO6_A1961MItemHelp = new String[] {""} ;
      P01UO6_A1956MItemBienTextDef = new String[] {""} ;
      P01UO6_A1957MItemIcoSVG = new String[] {""} ;
      P01UO6_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO6_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO6_A1944MItemPadreDef = new String[] {""} ;
      P01UO6_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO6_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO6_A1939MenuItemTitulo = new String[] {""} ;
      P01UO6_A1937MenuItemId = new String[] {""} ;
      P01UO6_A1925PerfilId = new byte[1] ;
      P01UO7_A1956MItemBienTextDef = new String[] {""} ;
      P01UO7_A1961MItemHelp = new String[] {""} ;
      P01UO7_A1955MItemBienTitDef = new String[] {""} ;
      P01UO7_A1957MItemIcoSVG = new String[] {""} ;
      P01UO7_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO7_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO7_A1944MItemPadreDef = new String[] {""} ;
      P01UO7_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO7_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO7_A1939MenuItemTitulo = new String[] {""} ;
      P01UO7_A1937MenuItemId = new String[] {""} ;
      P01UO7_A1925PerfilId = new byte[1] ;
      P01UO8_A1961MItemHelp = new String[] {""} ;
      P01UO8_A1956MItemBienTextDef = new String[] {""} ;
      P01UO8_A1955MItemBienTitDef = new String[] {""} ;
      P01UO8_A1957MItemIcoSVG = new String[] {""} ;
      P01UO8_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UO8_A1945MItemPadreObl = new boolean[] {false} ;
      P01UO8_A1944MItemPadreDef = new String[] {""} ;
      P01UO8_n1944MItemPadreDef = new boolean[] {false} ;
      P01UO8_A1938MItemEsMenu = new boolean[] {false} ;
      P01UO8_A1939MenuItemTitulo = new String[] {""} ;
      P01UO8_A1937MenuItemId = new String[] {""} ;
      P01UO8_A1925PerfilId = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuitemwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01UO2_A1937MenuItemId, P01UO2_A1961MItemHelp, P01UO2_A1956MItemBienTextDef, P01UO2_A1955MItemBienTitDef, P01UO2_A1957MItemIcoSVG, P01UO2_n1957MItemIcoSVG, P01UO2_A1945MItemPadreObl, P01UO2_A1944MItemPadreDef, P01UO2_n1944MItemPadreDef, P01UO2_A1938MItemEsMenu,
            P01UO2_A1939MenuItemTitulo, P01UO2_A1925PerfilId
            }
            , new Object[] {
            P01UO3_A1939MenuItemTitulo, P01UO3_A1961MItemHelp, P01UO3_A1956MItemBienTextDef, P01UO3_A1955MItemBienTitDef, P01UO3_A1957MItemIcoSVG, P01UO3_n1957MItemIcoSVG, P01UO3_A1945MItemPadreObl, P01UO3_A1944MItemPadreDef, P01UO3_n1944MItemPadreDef, P01UO3_A1938MItemEsMenu,
            P01UO3_A1937MenuItemId, P01UO3_A1925PerfilId
            }
            , new Object[] {
            P01UO4_A1944MItemPadreDef, P01UO4_n1944MItemPadreDef, P01UO4_A1961MItemHelp, P01UO4_A1956MItemBienTextDef, P01UO4_A1955MItemBienTitDef, P01UO4_A1957MItemIcoSVG, P01UO4_n1957MItemIcoSVG, P01UO4_A1945MItemPadreObl, P01UO4_A1938MItemEsMenu, P01UO4_A1939MenuItemTitulo,
            P01UO4_A1937MenuItemId, P01UO4_A1925PerfilId
            }
            , new Object[] {
            P01UO5_A1957MItemIcoSVG, P01UO5_n1957MItemIcoSVG, P01UO5_A1961MItemHelp, P01UO5_A1956MItemBienTextDef, P01UO5_A1955MItemBienTitDef, P01UO5_A1945MItemPadreObl, P01UO5_A1944MItemPadreDef, P01UO5_n1944MItemPadreDef, P01UO5_A1938MItemEsMenu, P01UO5_A1939MenuItemTitulo,
            P01UO5_A1937MenuItemId, P01UO5_A1925PerfilId
            }
            , new Object[] {
            P01UO6_A1955MItemBienTitDef, P01UO6_A1961MItemHelp, P01UO6_A1956MItemBienTextDef, P01UO6_A1957MItemIcoSVG, P01UO6_n1957MItemIcoSVG, P01UO6_A1945MItemPadreObl, P01UO6_A1944MItemPadreDef, P01UO6_n1944MItemPadreDef, P01UO6_A1938MItemEsMenu, P01UO6_A1939MenuItemTitulo,
            P01UO6_A1937MenuItemId, P01UO6_A1925PerfilId
            }
            , new Object[] {
            P01UO7_A1956MItemBienTextDef, P01UO7_A1961MItemHelp, P01UO7_A1955MItemBienTitDef, P01UO7_A1957MItemIcoSVG, P01UO7_n1957MItemIcoSVG, P01UO7_A1945MItemPadreObl, P01UO7_A1944MItemPadreDef, P01UO7_n1944MItemPadreDef, P01UO7_A1938MItemEsMenu, P01UO7_A1939MenuItemTitulo,
            P01UO7_A1937MenuItemId, P01UO7_A1925PerfilId
            }
            , new Object[] {
            P01UO8_A1961MItemHelp, P01UO8_A1956MItemBienTextDef, P01UO8_A1955MItemBienTitDef, P01UO8_A1957MItemIcoSVG, P01UO8_n1957MItemIcoSVG, P01UO8_A1945MItemPadreObl, P01UO8_A1944MItemPadreDef, P01UO8_n1944MItemPadreDef, P01UO8_A1938MItemEsMenu, P01UO8_A1939MenuItemTitulo,
            P01UO8_A1937MenuItemId, P01UO8_A1925PerfilId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV39TFPerfilId ;
   private byte AV40TFPerfilId_To ;
   private byte AV17TFMItemEsMenu_Sel ;
   private byte AV57TFMItemPadreObl_Sel ;
   private byte AV62Menuitemwwds_1_tfperfilid ;
   private byte AV63Menuitemwwds_2_tfperfilid_to ;
   private byte AV68Menuitemwwds_7_tfmitemesmenu_sel ;
   private byte AV71Menuitemwwds_10_tfmitempadreobl_sel ;
   private byte A1925PerfilId ;
   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV60GXV1 ;
   private int AV65Menuitemwwds_4_tfmenuitemid_sels_size ;
   private int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ;
   private int AV70Menuitemwwds_9_tfmitempadredef_sels_size ;
   private int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ;
   private int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ;
   private int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ;
   private int AV79Menuitemwwds_18_tfmitemhelp_sels_size ;
   private long AV24count ;
   private String AV52TFMItemIcoSVG ;
   private String AV72Menuitemwwds_11_tfmitemicosvg ;
   private String scmdbuf ;
   private String lV72Menuitemwwds_11_tfmitemicosvg ;
   private String A1957MItemIcoSVG ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1938MItemEsMenu ;
   private boolean A1945MItemPadreObl ;
   private boolean brk1UO2 ;
   private boolean n1957MItemIcoSVG ;
   private boolean n1944MItemPadreDef ;
   private boolean brk1UO4 ;
   private boolean brk1UO6 ;
   private boolean brk1UO8 ;
   private boolean brk1UO10 ;
   private boolean brk1UO12 ;
   private boolean brk1UO14 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV11TFMenuItemId_SelsJson ;
   private String AV14TFMenuItemTitulo_SelsJson ;
   private String AV54TFMItemPadreDef_SelsJson ;
   private String AV51TFMItemIcoSVG_SelsJson ;
   private String AV45TFMItemBienTitDef_SelsJson ;
   private String AV42TFMItemBienTextDef_SelsJson ;
   private String AV48TFMItemHelp_SelsJson ;
   private String A1956MItemBienTextDef ;
   private String A1961MItemHelp ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV12TFMenuItemId ;
   private String AV15TFMenuItemTitulo ;
   private String AV55TFMItemPadreDef ;
   private String AV46TFMItemBienTitDef ;
   private String AV43TFMItemBienTextDef ;
   private String AV49TFMItemHelp ;
   private String AV41MenuOpcCod ;
   private String A1937MenuItemId ;
   private String AV64Menuitemwwds_3_tfmenuitemid ;
   private String AV66Menuitemwwds_5_tfmenuitemtitulo ;
   private String AV69Menuitemwwds_8_tfmitempadredef ;
   private String AV74Menuitemwwds_13_tfmitembientitdef ;
   private String AV76Menuitemwwds_15_tfmitembientextdef ;
   private String AV78Menuitemwwds_17_tfmitemhelp ;
   private String lV64Menuitemwwds_3_tfmenuitemid ;
   private String lV66Menuitemwwds_5_tfmenuitemtitulo ;
   private String lV69Menuitemwwds_8_tfmitempadredef ;
   private String lV74Menuitemwwds_13_tfmitembientitdef ;
   private String lV76Menuitemwwds_15_tfmitembientextdef ;
   private String lV78Menuitemwwds_17_tfmitemhelp ;
   private String A1939MenuItemTitulo ;
   private String A1944MItemPadreDef ;
   private String A1955MItemBienTitDef ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UO2_A1937MenuItemId ;
   private String[] P01UO2_A1961MItemHelp ;
   private String[] P01UO2_A1956MItemBienTextDef ;
   private String[] P01UO2_A1955MItemBienTitDef ;
   private String[] P01UO2_A1957MItemIcoSVG ;
   private boolean[] P01UO2_n1957MItemIcoSVG ;
   private boolean[] P01UO2_A1945MItemPadreObl ;
   private String[] P01UO2_A1944MItemPadreDef ;
   private boolean[] P01UO2_n1944MItemPadreDef ;
   private boolean[] P01UO2_A1938MItemEsMenu ;
   private String[] P01UO2_A1939MenuItemTitulo ;
   private byte[] P01UO2_A1925PerfilId ;
   private String[] P01UO3_A1939MenuItemTitulo ;
   private String[] P01UO3_A1961MItemHelp ;
   private String[] P01UO3_A1956MItemBienTextDef ;
   private String[] P01UO3_A1955MItemBienTitDef ;
   private String[] P01UO3_A1957MItemIcoSVG ;
   private boolean[] P01UO3_n1957MItemIcoSVG ;
   private boolean[] P01UO3_A1945MItemPadreObl ;
   private String[] P01UO3_A1944MItemPadreDef ;
   private boolean[] P01UO3_n1944MItemPadreDef ;
   private boolean[] P01UO3_A1938MItemEsMenu ;
   private String[] P01UO3_A1937MenuItemId ;
   private byte[] P01UO3_A1925PerfilId ;
   private String[] P01UO4_A1944MItemPadreDef ;
   private boolean[] P01UO4_n1944MItemPadreDef ;
   private String[] P01UO4_A1961MItemHelp ;
   private String[] P01UO4_A1956MItemBienTextDef ;
   private String[] P01UO4_A1955MItemBienTitDef ;
   private String[] P01UO4_A1957MItemIcoSVG ;
   private boolean[] P01UO4_n1957MItemIcoSVG ;
   private boolean[] P01UO4_A1945MItemPadreObl ;
   private boolean[] P01UO4_A1938MItemEsMenu ;
   private String[] P01UO4_A1939MenuItemTitulo ;
   private String[] P01UO4_A1937MenuItemId ;
   private byte[] P01UO4_A1925PerfilId ;
   private String[] P01UO5_A1957MItemIcoSVG ;
   private boolean[] P01UO5_n1957MItemIcoSVG ;
   private String[] P01UO5_A1961MItemHelp ;
   private String[] P01UO5_A1956MItemBienTextDef ;
   private String[] P01UO5_A1955MItemBienTitDef ;
   private boolean[] P01UO5_A1945MItemPadreObl ;
   private String[] P01UO5_A1944MItemPadreDef ;
   private boolean[] P01UO5_n1944MItemPadreDef ;
   private boolean[] P01UO5_A1938MItemEsMenu ;
   private String[] P01UO5_A1939MenuItemTitulo ;
   private String[] P01UO5_A1937MenuItemId ;
   private byte[] P01UO5_A1925PerfilId ;
   private String[] P01UO6_A1955MItemBienTitDef ;
   private String[] P01UO6_A1961MItemHelp ;
   private String[] P01UO6_A1956MItemBienTextDef ;
   private String[] P01UO6_A1957MItemIcoSVG ;
   private boolean[] P01UO6_n1957MItemIcoSVG ;
   private boolean[] P01UO6_A1945MItemPadreObl ;
   private String[] P01UO6_A1944MItemPadreDef ;
   private boolean[] P01UO6_n1944MItemPadreDef ;
   private boolean[] P01UO6_A1938MItemEsMenu ;
   private String[] P01UO6_A1939MenuItemTitulo ;
   private String[] P01UO6_A1937MenuItemId ;
   private byte[] P01UO6_A1925PerfilId ;
   private String[] P01UO7_A1956MItemBienTextDef ;
   private String[] P01UO7_A1961MItemHelp ;
   private String[] P01UO7_A1955MItemBienTitDef ;
   private String[] P01UO7_A1957MItemIcoSVG ;
   private boolean[] P01UO7_n1957MItemIcoSVG ;
   private boolean[] P01UO7_A1945MItemPadreObl ;
   private String[] P01UO7_A1944MItemPadreDef ;
   private boolean[] P01UO7_n1944MItemPadreDef ;
   private boolean[] P01UO7_A1938MItemEsMenu ;
   private String[] P01UO7_A1939MenuItemTitulo ;
   private String[] P01UO7_A1937MenuItemId ;
   private byte[] P01UO7_A1925PerfilId ;
   private String[] P01UO8_A1961MItemHelp ;
   private String[] P01UO8_A1956MItemBienTextDef ;
   private String[] P01UO8_A1955MItemBienTitDef ;
   private String[] P01UO8_A1957MItemIcoSVG ;
   private boolean[] P01UO8_n1957MItemIcoSVG ;
   private boolean[] P01UO8_A1945MItemPadreObl ;
   private String[] P01UO8_A1944MItemPadreDef ;
   private boolean[] P01UO8_n1944MItemPadreDef ;
   private boolean[] P01UO8_A1938MItemEsMenu ;
   private String[] P01UO8_A1939MenuItemTitulo ;
   private String[] P01UO8_A1937MenuItemId ;
   private byte[] P01UO8_A1925PerfilId ;
   private GXSimpleCollection<String> AV53TFMItemIcoSVG_Sels ;
   private GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV13TFMenuItemId_Sels ;
   private GXSimpleCollection<String> AV16TFMenuItemTitulo_Sels ;
   private GXSimpleCollection<String> AV56TFMItemPadreDef_Sels ;
   private GXSimpleCollection<String> AV47TFMItemBienTitDef_Sels ;
   private GXSimpleCollection<String> AV44TFMItemBienTextDef_Sels ;
   private GXSimpleCollection<String> AV50TFMItemHelp_Sels ;
   private GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ;
   private GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ;
   private GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ;
   private GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ;
   private GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ;
   private GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class menuitemwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01UO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[9];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT MenuItemId, MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemIcoSVG, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemTitulo, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MenuItemId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01UO3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[9];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT MenuItemTitulo, MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemIcoSVG, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MenuItemTitulo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01UO4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[9];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT MItemPadreDef, MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemIcoSVG, MItemPadreObl, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MItemPadreDef" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P01UO5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[9];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT MItemIcoSVG, MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int17[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MItemIcoSVG" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P01UO6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[9];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT MItemBienTitDef, MItemHelp, MItemBienTextDef, MItemIcoSVG, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int20[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int20[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MItemBienTitDef" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   protected Object[] conditional_P01UO7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[9];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT MItemBienTextDef, MItemHelp, MItemBienTitDef, MItemIcoSVG, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int23[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int23[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int23[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int23[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int23[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int23[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int23[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int23[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MItemBienTextDef" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_P01UO8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV65Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV67Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV70Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV73Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV75Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV77Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV79Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV62Menuitemwwds_1_tfperfilid ,
                                          byte AV63Menuitemwwds_2_tfperfilid_to ,
                                          int AV65Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV64Menuitemwwds_3_tfmenuitemid ,
                                          int AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV66Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV68Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV70Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV69Menuitemwwds_8_tfmitempadredef ,
                                          byte AV71Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV73Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV72Menuitemwwds_11_tfmitemicosvg ,
                                          int AV75Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV74Menuitemwwds_13_tfmitembientitdef ,
                                          int AV77Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV76Menuitemwwds_15_tfmitembientextdef ,
                                          int AV79Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV78Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[9];
      Object[] GXv_Object27 = new Object[2];
      scmdbuf = "SELECT MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemIcoSVG, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV62Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int26[0] = (byte)(1) ;
      }
      if ( ! (0==AV63Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int26[1] = (byte)(1) ;
      }
      if ( ( AV65Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int26[2] = (byte)(1) ;
      }
      if ( AV65Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int26[3] = (byte)(1) ;
      }
      if ( AV67Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV68Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV70Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[4] = (byte)(1) ;
      }
      if ( AV70Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV71Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int26[5] = (byte)(1) ;
      }
      if ( AV73Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[6] = (byte)(1) ;
      }
      if ( AV75Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[7] = (byte)(1) ;
      }
      if ( AV77Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV79Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int26[8] = (byte)(1) ;
      }
      if ( AV79Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MItemHelp" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01UO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
            case 1 :
                  return conditional_P01UO3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
            case 2 :
                  return conditional_P01UO4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
            case 3 :
                  return conditional_P01UO5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
            case 4 :
                  return conditional_P01UO6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
            case 5 :
                  return conditional_P01UO7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
            case 6 :
                  return conditional_P01UO8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[36]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UO3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UO4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UO5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UO6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UO7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UO8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
      }
   }

}


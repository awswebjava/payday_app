package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuversioneswwgetfilterdata extends GXProcedure
{
   public menuversioneswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuversioneswwgetfilterdata.class ), "" );
   }

   public menuversioneswwgetfilterdata( int remoteHandle ,
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
      menuversioneswwgetfilterdata.this.aP5 = new String[] {""};
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
      menuversioneswwgetfilterdata.this.AV34DDOName = aP0;
      menuversioneswwgetfilterdata.this.AV35SearchTxt = aP1;
      menuversioneswwgetfilterdata.this.AV36SearchTxtTo = aP2;
      menuversioneswwgetfilterdata.this.aP3 = aP3;
      menuversioneswwgetfilterdata.this.aP4 = aP4;
      menuversioneswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV41EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      menuversioneswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV41EmpCod = GXt_int1 ;
      GXt_int3 = AV42CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      menuversioneswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV42CliCod = GXt_int3 ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones", GXv_boolean6) ;
      menuversioneswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_ROLNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADROLNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_PERFILNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADPERFILNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_MENUPAIS") == 0 )
         {
            /* Execute user subroutine: 'LOADMENUPAISOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV37OptionsJson = AV24Options.toJSonString(false) ;
      AV38OptionsDescJson = AV26OptionsDesc.toJSonString(false) ;
      AV39OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV29Session.getValue("MenuVersionesWWGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MenuVersionesWWGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("MenuVersionesWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE") == 0 )
         {
            AV12TFRolNombre = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE_SEL") == 0 )
         {
            AV11TFRolNombre_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFRolNombre_Sels.fromJSonString(AV11TFRolNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILNOMBRE") == 0 )
         {
            AV15TFPerfilNombre = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILNOMBRE_SEL") == 0 )
         {
            AV14TFPerfilNombre_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFPerfilNombre_Sels.fromJSonString(AV14TFPerfilNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUVERID") == 0 )
         {
            AV17TFMenuVerId = GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV18TFMenuVerId_To = GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUPAIS") == 0 )
         {
            AV20TFMenuPais = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUPAIS_SEL") == 0 )
         {
            AV19TFMenuPais_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV21TFMenuPais_Sels.fromJSonString(AV19TFMenuPais_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV43MenuOpcCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADROLNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV12TFRolNombre = AV35SearchTxt ;
      AV13TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Menuversioneswwds_1_tfrolnombre = AV12TFRolNombre ;
      AV49Menuversioneswwds_2_tfrolnombre_sels = AV13TFRolNombre_Sels ;
      AV50Menuversioneswwds_3_tfperfilnombre = AV15TFPerfilNombre ;
      AV51Menuversioneswwds_4_tfperfilnombre_sels = AV16TFPerfilNombre_Sels ;
      AV52Menuversioneswwds_5_tfmenuverid = AV17TFMenuVerId ;
      AV53Menuversioneswwds_6_tfmenuverid_to = AV18TFMenuVerId_To ;
      AV54Menuversioneswwds_7_tfmenupais = AV20TFMenuPais ;
      AV55Menuversioneswwds_8_tfmenupais_sels = AV21TFMenuPais_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1924RolNombre ,
                                           AV49Menuversioneswwds_2_tfrolnombre_sels ,
                                           A1926PerfilNombre ,
                                           AV51Menuversioneswwds_4_tfperfilnombre_sels ,
                                           Short.valueOf(A1927MenuPais) ,
                                           AV55Menuversioneswwds_8_tfmenupais_sels ,
                                           Integer.valueOf(AV49Menuversioneswwds_2_tfrolnombre_sels.size()) ,
                                           AV48Menuversioneswwds_1_tfrolnombre ,
                                           Integer.valueOf(AV51Menuversioneswwds_4_tfperfilnombre_sels.size()) ,
                                           AV50Menuversioneswwds_3_tfperfilnombre ,
                                           Long.valueOf(AV52Menuversioneswwds_5_tfmenuverid) ,
                                           Long.valueOf(AV53Menuversioneswwds_6_tfmenuverid_to) ,
                                           Integer.valueOf(AV55Menuversioneswwds_8_tfmenupais_sels.size()) ,
                                           AV54Menuversioneswwds_7_tfmenupais ,
                                           Long.valueOf(A1928MenuVerId) ,
                                           A312PaiNom ,
                                           Integer.valueOf(AV42CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV48Menuversioneswwds_1_tfrolnombre = GXutil.concat( GXutil.rtrim( AV48Menuversioneswwds_1_tfrolnombre), "%", "") ;
      lV50Menuversioneswwds_3_tfperfilnombre = GXutil.concat( GXutil.rtrim( AV50Menuversioneswwds_3_tfperfilnombre), "%", "") ;
      lV54Menuversioneswwds_7_tfmenupais = GXutil.concat( GXutil.rtrim( AV54Menuversioneswwds_7_tfmenupais), "%", "") ;
      /* Using cursor P01US2 */
      pr_default.execute(0, new Object[] {lV48Menuversioneswwds_1_tfrolnombre, lV50Menuversioneswwds_3_tfperfilnombre, Long.valueOf(AV52Menuversioneswwds_5_tfmenuverid), Long.valueOf(AV53Menuversioneswwds_6_tfmenuverid_to), lV54Menuversioneswwds_7_tfmenupais});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1US2 = false ;
         A1923RolId = P01US2_A1923RolId[0] ;
         A1925PerfilId = P01US2_A1925PerfilId[0] ;
         A1924RolNombre = P01US2_A1924RolNombre[0] ;
         A312PaiNom = P01US2_A312PaiNom[0] ;
         n312PaiNom = P01US2_n312PaiNom[0] ;
         A1927MenuPais = P01US2_A1927MenuPais[0] ;
         n1927MenuPais = P01US2_n1927MenuPais[0] ;
         A1928MenuVerId = P01US2_A1928MenuVerId[0] ;
         A1926PerfilNombre = P01US2_A1926PerfilNombre[0] ;
         A1924RolNombre = P01US2_A1924RolNombre[0] ;
         A1926PerfilNombre = P01US2_A1926PerfilNombre[0] ;
         A312PaiNom = P01US2_A312PaiNom[0] ;
         n312PaiNom = P01US2_n312PaiNom[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01US2_A1924RolNombre[0], A1924RolNombre) == 0 ) )
         {
            brk1US2 = false ;
            A1923RolId = P01US2_A1923RolId[0] ;
            A1925PerfilId = P01US2_A1925PerfilId[0] ;
            A1928MenuVerId = P01US2_A1928MenuVerId[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1US2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1924RolNombre)==0) )
         {
            AV23Option = A1924RolNombre ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1US2 )
         {
            brk1US2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPERFILNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV15TFPerfilNombre = AV35SearchTxt ;
      AV16TFPerfilNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Menuversioneswwds_1_tfrolnombre = AV12TFRolNombre ;
      AV49Menuversioneswwds_2_tfrolnombre_sels = AV13TFRolNombre_Sels ;
      AV50Menuversioneswwds_3_tfperfilnombre = AV15TFPerfilNombre ;
      AV51Menuversioneswwds_4_tfperfilnombre_sels = AV16TFPerfilNombre_Sels ;
      AV52Menuversioneswwds_5_tfmenuverid = AV17TFMenuVerId ;
      AV53Menuversioneswwds_6_tfmenuverid_to = AV18TFMenuVerId_To ;
      AV54Menuversioneswwds_7_tfmenupais = AV20TFMenuPais ;
      AV55Menuversioneswwds_8_tfmenupais_sels = AV21TFMenuPais_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1924RolNombre ,
                                           AV49Menuversioneswwds_2_tfrolnombre_sels ,
                                           A1926PerfilNombre ,
                                           AV51Menuversioneswwds_4_tfperfilnombre_sels ,
                                           Short.valueOf(A1927MenuPais) ,
                                           AV55Menuversioneswwds_8_tfmenupais_sels ,
                                           Integer.valueOf(AV49Menuversioneswwds_2_tfrolnombre_sels.size()) ,
                                           AV48Menuversioneswwds_1_tfrolnombre ,
                                           Integer.valueOf(AV51Menuversioneswwds_4_tfperfilnombre_sels.size()) ,
                                           AV50Menuversioneswwds_3_tfperfilnombre ,
                                           Long.valueOf(AV52Menuversioneswwds_5_tfmenuverid) ,
                                           Long.valueOf(AV53Menuversioneswwds_6_tfmenuverid_to) ,
                                           Integer.valueOf(AV55Menuversioneswwds_8_tfmenupais_sels.size()) ,
                                           AV54Menuversioneswwds_7_tfmenupais ,
                                           Long.valueOf(A1928MenuVerId) ,
                                           A312PaiNom ,
                                           Integer.valueOf(AV42CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV48Menuversioneswwds_1_tfrolnombre = GXutil.concat( GXutil.rtrim( AV48Menuversioneswwds_1_tfrolnombre), "%", "") ;
      lV50Menuversioneswwds_3_tfperfilnombre = GXutil.concat( GXutil.rtrim( AV50Menuversioneswwds_3_tfperfilnombre), "%", "") ;
      lV54Menuversioneswwds_7_tfmenupais = GXutil.concat( GXutil.rtrim( AV54Menuversioneswwds_7_tfmenupais), "%", "") ;
      /* Using cursor P01US3 */
      pr_default.execute(1, new Object[] {lV48Menuversioneswwds_1_tfrolnombre, lV50Menuversioneswwds_3_tfperfilnombre, Long.valueOf(AV52Menuversioneswwds_5_tfmenuverid), Long.valueOf(AV53Menuversioneswwds_6_tfmenuverid_to), lV54Menuversioneswwds_7_tfmenupais});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1US4 = false ;
         A1923RolId = P01US3_A1923RolId[0] ;
         A1925PerfilId = P01US3_A1925PerfilId[0] ;
         A1926PerfilNombre = P01US3_A1926PerfilNombre[0] ;
         A312PaiNom = P01US3_A312PaiNom[0] ;
         n312PaiNom = P01US3_n312PaiNom[0] ;
         A1927MenuPais = P01US3_A1927MenuPais[0] ;
         n1927MenuPais = P01US3_n1927MenuPais[0] ;
         A1928MenuVerId = P01US3_A1928MenuVerId[0] ;
         A1924RolNombre = P01US3_A1924RolNombre[0] ;
         A1924RolNombre = P01US3_A1924RolNombre[0] ;
         A1926PerfilNombre = P01US3_A1926PerfilNombre[0] ;
         A312PaiNom = P01US3_A312PaiNom[0] ;
         n312PaiNom = P01US3_n312PaiNom[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01US3_A1926PerfilNombre[0], A1926PerfilNombre) == 0 ) )
         {
            brk1US4 = false ;
            A1923RolId = P01US3_A1923RolId[0] ;
            A1925PerfilId = P01US3_A1925PerfilId[0] ;
            A1928MenuVerId = P01US3_A1928MenuVerId[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1US4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1926PerfilNombre)==0) )
         {
            AV23Option = A1926PerfilNombre ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1US4 )
         {
            brk1US4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMENUPAISOPTIONS' Routine */
      returnInSub = false ;
      AV20TFMenuPais = AV35SearchTxt ;
      AV21TFMenuPais_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV48Menuversioneswwds_1_tfrolnombre = AV12TFRolNombre ;
      AV49Menuversioneswwds_2_tfrolnombre_sels = AV13TFRolNombre_Sels ;
      AV50Menuversioneswwds_3_tfperfilnombre = AV15TFPerfilNombre ;
      AV51Menuversioneswwds_4_tfperfilnombre_sels = AV16TFPerfilNombre_Sels ;
      AV52Menuversioneswwds_5_tfmenuverid = AV17TFMenuVerId ;
      AV53Menuversioneswwds_6_tfmenuverid_to = AV18TFMenuVerId_To ;
      AV54Menuversioneswwds_7_tfmenupais = AV20TFMenuPais ;
      AV55Menuversioneswwds_8_tfmenupais_sels = AV21TFMenuPais_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1924RolNombre ,
                                           AV49Menuversioneswwds_2_tfrolnombre_sels ,
                                           A1926PerfilNombre ,
                                           AV51Menuversioneswwds_4_tfperfilnombre_sels ,
                                           Short.valueOf(A1927MenuPais) ,
                                           AV55Menuversioneswwds_8_tfmenupais_sels ,
                                           Integer.valueOf(AV49Menuversioneswwds_2_tfrolnombre_sels.size()) ,
                                           AV48Menuversioneswwds_1_tfrolnombre ,
                                           Integer.valueOf(AV51Menuversioneswwds_4_tfperfilnombre_sels.size()) ,
                                           AV50Menuversioneswwds_3_tfperfilnombre ,
                                           Long.valueOf(AV52Menuversioneswwds_5_tfmenuverid) ,
                                           Long.valueOf(AV53Menuversioneswwds_6_tfmenuverid_to) ,
                                           Integer.valueOf(AV55Menuversioneswwds_8_tfmenupais_sels.size()) ,
                                           AV54Menuversioneswwds_7_tfmenupais ,
                                           Long.valueOf(A1928MenuVerId) ,
                                           A312PaiNom ,
                                           Integer.valueOf(AV42CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV48Menuversioneswwds_1_tfrolnombre = GXutil.concat( GXutil.rtrim( AV48Menuversioneswwds_1_tfrolnombre), "%", "") ;
      lV50Menuversioneswwds_3_tfperfilnombre = GXutil.concat( GXutil.rtrim( AV50Menuversioneswwds_3_tfperfilnombre), "%", "") ;
      lV54Menuversioneswwds_7_tfmenupais = GXutil.concat( GXutil.rtrim( AV54Menuversioneswwds_7_tfmenupais), "%", "") ;
      /* Using cursor P01US4 */
      pr_default.execute(2, new Object[] {lV48Menuversioneswwds_1_tfrolnombre, lV50Menuversioneswwds_3_tfperfilnombre, Long.valueOf(AV52Menuversioneswwds_5_tfmenuverid), Long.valueOf(AV53Menuversioneswwds_6_tfmenuverid_to), lV54Menuversioneswwds_7_tfmenupais});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1US6 = false ;
         A1923RolId = P01US4_A1923RolId[0] ;
         A1925PerfilId = P01US4_A1925PerfilId[0] ;
         A1927MenuPais = P01US4_A1927MenuPais[0] ;
         n1927MenuPais = P01US4_n1927MenuPais[0] ;
         A312PaiNom = P01US4_A312PaiNom[0] ;
         n312PaiNom = P01US4_n312PaiNom[0] ;
         A1928MenuVerId = P01US4_A1928MenuVerId[0] ;
         A1926PerfilNombre = P01US4_A1926PerfilNombre[0] ;
         A1924RolNombre = P01US4_A1924RolNombre[0] ;
         A1924RolNombre = P01US4_A1924RolNombre[0] ;
         A1926PerfilNombre = P01US4_A1926PerfilNombre[0] ;
         A312PaiNom = P01US4_A312PaiNom[0] ;
         n312PaiNom = P01US4_n312PaiNom[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P01US4_A1927MenuPais[0] == A1927MenuPais ) )
         {
            brk1US6 = false ;
            A1923RolId = P01US4_A1923RolId[0] ;
            A1925PerfilId = P01US4_A1925PerfilId[0] ;
            A1928MenuVerId = P01US4_A1928MenuVerId[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1US6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A312PaiNom)==0) )
         {
            AV23Option = GXutil.str( A1927MenuPais, 4, 0) ;
            AV25OptionDesc = A312PaiNom ;
            AV22InsertIndex = 1 ;
            while ( ( AV22InsertIndex <= AV24Options.size() ) && ( GXutil.strcmp((String)AV26OptionsDesc.elementAt(-1+AV22InsertIndex), AV25OptionDesc) < 0 ) )
            {
               AV22InsertIndex = (int)(AV22InsertIndex+1) ;
            }
            AV24Options.add(AV23Option, AV22InsertIndex);
            AV26OptionsDesc.add(AV25OptionDesc, AV22InsertIndex);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), AV22InsertIndex);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1US6 )
         {
            brk1US6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = menuversioneswwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = menuversioneswwgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = menuversioneswwgetfilterdata.this.AV39OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV37OptionsJson = "" ;
      AV38OptionsDescJson = "" ;
      AV39OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV29Session = httpContext.getWebSession();
      AV31GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV32GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFRolNombre = "" ;
      AV11TFRolNombre_SelsJson = "" ;
      AV13TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFPerfilNombre = "" ;
      AV14TFPerfilNombre_SelsJson = "" ;
      AV16TFPerfilNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFMenuPais = "" ;
      AV19TFMenuPais_SelsJson = "" ;
      AV21TFMenuPais_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV43MenuOpcCod = "" ;
      A1924RolNombre = "" ;
      AV48Menuversioneswwds_1_tfrolnombre = "" ;
      AV49Menuversioneswwds_2_tfrolnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Menuversioneswwds_3_tfperfilnombre = "" ;
      AV51Menuversioneswwds_4_tfperfilnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Menuversioneswwds_7_tfmenupais = "" ;
      AV55Menuversioneswwds_8_tfmenupais_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      scmdbuf = "" ;
      lV48Menuversioneswwds_1_tfrolnombre = "" ;
      lV50Menuversioneswwds_3_tfperfilnombre = "" ;
      lV54Menuversioneswwds_7_tfmenupais = "" ;
      A1926PerfilNombre = "" ;
      A312PaiNom = "" ;
      P01US2_A1923RolId = new byte[1] ;
      P01US2_A1925PerfilId = new byte[1] ;
      P01US2_A1924RolNombre = new String[] {""} ;
      P01US2_A312PaiNom = new String[] {""} ;
      P01US2_n312PaiNom = new boolean[] {false} ;
      P01US2_A1927MenuPais = new short[1] ;
      P01US2_n1927MenuPais = new boolean[] {false} ;
      P01US2_A1928MenuVerId = new long[1] ;
      P01US2_A1926PerfilNombre = new String[] {""} ;
      AV23Option = "" ;
      P01US3_A1923RolId = new byte[1] ;
      P01US3_A1925PerfilId = new byte[1] ;
      P01US3_A1926PerfilNombre = new String[] {""} ;
      P01US3_A312PaiNom = new String[] {""} ;
      P01US3_n312PaiNom = new boolean[] {false} ;
      P01US3_A1927MenuPais = new short[1] ;
      P01US3_n1927MenuPais = new boolean[] {false} ;
      P01US3_A1928MenuVerId = new long[1] ;
      P01US3_A1924RolNombre = new String[] {""} ;
      P01US4_A1923RolId = new byte[1] ;
      P01US4_A1925PerfilId = new byte[1] ;
      P01US4_A1927MenuPais = new short[1] ;
      P01US4_n1927MenuPais = new boolean[] {false} ;
      P01US4_A312PaiNom = new String[] {""} ;
      P01US4_n312PaiNom = new boolean[] {false} ;
      P01US4_A1928MenuVerId = new long[1] ;
      P01US4_A1926PerfilNombre = new String[] {""} ;
      P01US4_A1924RolNombre = new String[] {""} ;
      AV25OptionDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuversioneswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01US2_A1923RolId, P01US2_A1925PerfilId, P01US2_A1924RolNombre, P01US2_A312PaiNom, P01US2_n312PaiNom, P01US2_A1927MenuPais, P01US2_n1927MenuPais, P01US2_A1928MenuVerId, P01US2_A1926PerfilNombre
            }
            , new Object[] {
            P01US3_A1923RolId, P01US3_A1925PerfilId, P01US3_A1926PerfilNombre, P01US3_A312PaiNom, P01US3_n312PaiNom, P01US3_A1927MenuPais, P01US3_n1927MenuPais, P01US3_A1928MenuVerId, P01US3_A1924RolNombre
            }
            , new Object[] {
            P01US4_A1923RolId, P01US4_A1925PerfilId, P01US4_A1927MenuPais, P01US4_n1927MenuPais, P01US4_A312PaiNom, P01US4_n312PaiNom, P01US4_A1928MenuVerId, P01US4_A1926PerfilNombre, P01US4_A1924RolNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private short AV41EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1927MenuPais ;
   private short Gx_err ;
   private int AV42CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV46GXV1 ;
   private int AV49Menuversioneswwds_2_tfrolnombre_sels_size ;
   private int AV51Menuversioneswwds_4_tfperfilnombre_sels_size ;
   private int AV55Menuversioneswwds_8_tfmenupais_sels_size ;
   private int AV22InsertIndex ;
   private long AV17TFMenuVerId ;
   private long AV18TFMenuVerId_To ;
   private long AV52Menuversioneswwds_5_tfmenuverid ;
   private long AV53Menuversioneswwds_6_tfmenuverid_to ;
   private long A1928MenuVerId ;
   private long AV28count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1US2 ;
   private boolean n312PaiNom ;
   private boolean n1927MenuPais ;
   private boolean brk1US4 ;
   private boolean brk1US6 ;
   private String AV37OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV39OptionIndexesJson ;
   private String AV11TFRolNombre_SelsJson ;
   private String AV14TFPerfilNombre_SelsJson ;
   private String AV19TFMenuPais_SelsJson ;
   private String AV34DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV12TFRolNombre ;
   private String AV15TFPerfilNombre ;
   private String AV20TFMenuPais ;
   private String AV43MenuOpcCod ;
   private String A1924RolNombre ;
   private String AV48Menuversioneswwds_1_tfrolnombre ;
   private String AV50Menuversioneswwds_3_tfperfilnombre ;
   private String AV54Menuversioneswwds_7_tfmenupais ;
   private String lV48Menuversioneswwds_1_tfrolnombre ;
   private String lV50Menuversioneswwds_3_tfperfilnombre ;
   private String lV54Menuversioneswwds_7_tfmenupais ;
   private String A1926PerfilNombre ;
   private String A312PaiNom ;
   private String AV23Option ;
   private String AV25OptionDesc ;
   private GXSimpleCollection<Short> AV21TFMenuPais_Sels ;
   private GXSimpleCollection<Short> AV55Menuversioneswwds_8_tfmenupais_sels ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01US2_A1923RolId ;
   private byte[] P01US2_A1925PerfilId ;
   private String[] P01US2_A1924RolNombre ;
   private String[] P01US2_A312PaiNom ;
   private boolean[] P01US2_n312PaiNom ;
   private short[] P01US2_A1927MenuPais ;
   private boolean[] P01US2_n1927MenuPais ;
   private long[] P01US2_A1928MenuVerId ;
   private String[] P01US2_A1926PerfilNombre ;
   private byte[] P01US3_A1923RolId ;
   private byte[] P01US3_A1925PerfilId ;
   private String[] P01US3_A1926PerfilNombre ;
   private String[] P01US3_A312PaiNom ;
   private boolean[] P01US3_n312PaiNom ;
   private short[] P01US3_A1927MenuPais ;
   private boolean[] P01US3_n1927MenuPais ;
   private long[] P01US3_A1928MenuVerId ;
   private String[] P01US3_A1924RolNombre ;
   private byte[] P01US4_A1923RolId ;
   private byte[] P01US4_A1925PerfilId ;
   private short[] P01US4_A1927MenuPais ;
   private boolean[] P01US4_n1927MenuPais ;
   private String[] P01US4_A312PaiNom ;
   private boolean[] P01US4_n312PaiNom ;
   private long[] P01US4_A1928MenuVerId ;
   private String[] P01US4_A1926PerfilNombre ;
   private String[] P01US4_A1924RolNombre ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV13TFRolNombre_Sels ;
   private GXSimpleCollection<String> AV16TFPerfilNombre_Sels ;
   private GXSimpleCollection<String> AV49Menuversioneswwds_2_tfrolnombre_sels ;
   private GXSimpleCollection<String> AV51Menuversioneswwds_4_tfperfilnombre_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class menuversioneswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01US2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV49Menuversioneswwds_2_tfrolnombre_sels ,
                                          String A1926PerfilNombre ,
                                          GXSimpleCollection<String> AV51Menuversioneswwds_4_tfperfilnombre_sels ,
                                          short A1927MenuPais ,
                                          GXSimpleCollection<Short> AV55Menuversioneswwds_8_tfmenupais_sels ,
                                          int AV49Menuversioneswwds_2_tfrolnombre_sels_size ,
                                          String AV48Menuversioneswwds_1_tfrolnombre ,
                                          int AV51Menuversioneswwds_4_tfperfilnombre_sels_size ,
                                          String AV50Menuversioneswwds_3_tfperfilnombre ,
                                          long AV52Menuversioneswwds_5_tfmenuverid ,
                                          long AV53Menuversioneswwds_6_tfmenuverid_to ,
                                          int AV55Menuversioneswwds_8_tfmenupais_sels_size ,
                                          String AV54Menuversioneswwds_7_tfmenupais ,
                                          long A1928MenuVerId ,
                                          String A312PaiNom ,
                                          int AV42CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.PerfilId, T2.RolNombre, T4.PaiNom, T1.MenuPais AS MenuPais, T1.MenuVerId, T3.PerfilNombre FROM (((MenuVersiones T1 INNER JOIN RolUsuario T2 ON" ;
      scmdbuf += " T2.RolId = T1.RolId) INNER JOIN Perfil T3 ON T3.PerfilId = T1.PerfilId) LEFT JOIN Pais T4 ON T4.PaiCod = T1.MenuPais)" ;
      if ( ( AV49Menuversioneswwds_2_tfrolnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Menuversioneswwds_1_tfrolnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV49Menuversioneswwds_2_tfrolnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Menuversioneswwds_2_tfrolnombre_sels, "T2.RolNombre IN (", ")")+")");
      }
      if ( ( AV51Menuversioneswwds_4_tfperfilnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Menuversioneswwds_3_tfperfilnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.PerfilNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV51Menuversioneswwds_4_tfperfilnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Menuversioneswwds_4_tfperfilnombre_sels, "T3.PerfilNombre IN (", ")")+")");
      }
      if ( ! (0==AV52Menuversioneswwds_5_tfmenuverid) )
      {
         addWhere(sWhereString, "(T1.MenuVerId >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV53Menuversioneswwds_6_tfmenuverid_to) )
      {
         addWhere(sWhereString, "(T1.MenuVerId <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV55Menuversioneswwds_8_tfmenupais_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Menuversioneswwds_7_tfmenupais)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV55Menuversioneswwds_8_tfmenupais_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Menuversioneswwds_8_tfmenupais_sels, "T1.MenuPais IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.RolNombre" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01US3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV49Menuversioneswwds_2_tfrolnombre_sels ,
                                          String A1926PerfilNombre ,
                                          GXSimpleCollection<String> AV51Menuversioneswwds_4_tfperfilnombre_sels ,
                                          short A1927MenuPais ,
                                          GXSimpleCollection<Short> AV55Menuversioneswwds_8_tfmenupais_sels ,
                                          int AV49Menuversioneswwds_2_tfrolnombre_sels_size ,
                                          String AV48Menuversioneswwds_1_tfrolnombre ,
                                          int AV51Menuversioneswwds_4_tfperfilnombre_sels_size ,
                                          String AV50Menuversioneswwds_3_tfperfilnombre ,
                                          long AV52Menuversioneswwds_5_tfmenuverid ,
                                          long AV53Menuversioneswwds_6_tfmenuverid_to ,
                                          int AV55Menuversioneswwds_8_tfmenupais_sels_size ,
                                          String AV54Menuversioneswwds_7_tfmenupais ,
                                          long A1928MenuVerId ,
                                          String A312PaiNom ,
                                          int AV42CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.PerfilId, T3.PerfilNombre, T4.PaiNom, T1.MenuPais AS MenuPais, T1.MenuVerId, T2.RolNombre FROM (((MenuVersiones T1 INNER JOIN RolUsuario T2 ON" ;
      scmdbuf += " T2.RolId = T1.RolId) INNER JOIN Perfil T3 ON T3.PerfilId = T1.PerfilId) LEFT JOIN Pais T4 ON T4.PaiCod = T1.MenuPais)" ;
      if ( ( AV49Menuversioneswwds_2_tfrolnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Menuversioneswwds_1_tfrolnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV49Menuversioneswwds_2_tfrolnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Menuversioneswwds_2_tfrolnombre_sels, "T2.RolNombre IN (", ")")+")");
      }
      if ( ( AV51Menuversioneswwds_4_tfperfilnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Menuversioneswwds_3_tfperfilnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.PerfilNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV51Menuversioneswwds_4_tfperfilnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Menuversioneswwds_4_tfperfilnombre_sels, "T3.PerfilNombre IN (", ")")+")");
      }
      if ( ! (0==AV52Menuversioneswwds_5_tfmenuverid) )
      {
         addWhere(sWhereString, "(T1.MenuVerId >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV53Menuversioneswwds_6_tfmenuverid_to) )
      {
         addWhere(sWhereString, "(T1.MenuVerId <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV55Menuversioneswwds_8_tfmenupais_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Menuversioneswwds_7_tfmenupais)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV55Menuversioneswwds_8_tfmenupais_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Menuversioneswwds_8_tfmenupais_sels, "T1.MenuPais IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.PerfilNombre" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01US4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV49Menuversioneswwds_2_tfrolnombre_sels ,
                                          String A1926PerfilNombre ,
                                          GXSimpleCollection<String> AV51Menuversioneswwds_4_tfperfilnombre_sels ,
                                          short A1927MenuPais ,
                                          GXSimpleCollection<Short> AV55Menuversioneswwds_8_tfmenupais_sels ,
                                          int AV49Menuversioneswwds_2_tfrolnombre_sels_size ,
                                          String AV48Menuversioneswwds_1_tfrolnombre ,
                                          int AV51Menuversioneswwds_4_tfperfilnombre_sels_size ,
                                          String AV50Menuversioneswwds_3_tfperfilnombre ,
                                          long AV52Menuversioneswwds_5_tfmenuverid ,
                                          long AV53Menuversioneswwds_6_tfmenuverid_to ,
                                          int AV55Menuversioneswwds_8_tfmenupais_sels_size ,
                                          String AV54Menuversioneswwds_7_tfmenupais ,
                                          long A1928MenuVerId ,
                                          String A312PaiNom ,
                                          int AV42CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[5];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.PerfilId, T1.MenuPais AS MenuPais, T4.PaiNom, T1.MenuVerId, T3.PerfilNombre, T2.RolNombre FROM (((MenuVersiones T1 INNER JOIN RolUsuario T2 ON" ;
      scmdbuf += " T2.RolId = T1.RolId) INNER JOIN Perfil T3 ON T3.PerfilId = T1.PerfilId) LEFT JOIN Pais T4 ON T4.PaiCod = T1.MenuPais)" ;
      if ( ( AV49Menuversioneswwds_2_tfrolnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Menuversioneswwds_1_tfrolnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV49Menuversioneswwds_2_tfrolnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Menuversioneswwds_2_tfrolnombre_sels, "T2.RolNombre IN (", ")")+")");
      }
      if ( ( AV51Menuversioneswwds_4_tfperfilnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Menuversioneswwds_3_tfperfilnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.PerfilNombre) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV51Menuversioneswwds_4_tfperfilnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Menuversioneswwds_4_tfperfilnombre_sels, "T3.PerfilNombre IN (", ")")+")");
      }
      if ( ! (0==AV52Menuversioneswwds_5_tfmenuverid) )
      {
         addWhere(sWhereString, "(T1.MenuVerId >= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ! (0==AV53Menuversioneswwds_6_tfmenuverid_to) )
      {
         addWhere(sWhereString, "(T1.MenuVerId <= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ( AV55Menuversioneswwds_8_tfmenupais_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Menuversioneswwds_7_tfmenupais)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV55Menuversioneswwds_8_tfmenupais_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Menuversioneswwds_8_tfmenupais_sels, "T1.MenuPais IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.MenuPais" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P01US2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , (String)dynConstraints[15] , ((Number) dynConstraints[17]).intValue() );
            case 1 :
                  return conditional_P01US3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , (String)dynConstraints[15] , ((Number) dynConstraints[17]).intValue() );
            case 2 :
                  return conditional_P01US4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , (String)dynConstraints[15] , ((Number) dynConstraints[17]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01US2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01US3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01US4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((long[]) buf[7])[0] = rslt.getLong(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((long[]) buf[7])[0] = rslt.getLong(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
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
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[8]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[8]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[8]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               return;
      }
   }

}


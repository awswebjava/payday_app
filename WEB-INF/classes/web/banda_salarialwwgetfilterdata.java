package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class banda_salarialwwgetfilterdata extends GXProcedure
{
   public banda_salarialwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( banda_salarialwwgetfilterdata.class ), "" );
   }

   public banda_salarialwwgetfilterdata( int remoteHandle ,
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
      banda_salarialwwgetfilterdata.this.aP5 = new String[] {""};
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
      banda_salarialwwgetfilterdata.this.AV33DDOName = aP0;
      banda_salarialwwgetfilterdata.this.AV34SearchTxt = aP1;
      banda_salarialwwgetfilterdata.this.AV35SearchTxtTo = aP2;
      banda_salarialwwgetfilterdata.this.aP3 = aP3;
      banda_salarialwwgetfilterdata.this.aP4 = aP4;
      banda_salarialwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      banda_salarialwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      banda_salarialwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWbanda_salarial", GXv_boolean6) ;
      banda_salarialwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_BANSANOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADBANSANOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_BANSALDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADBANSALDESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV36OptionsJson = AV23Options.toJSonString(false) ;
      AV37OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV38OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("banda_salarialWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "banda_salarialWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("banda_salarialWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSANOMBRE") == 0 )
         {
            AV12TFBanSaNombre = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSANOMBRE_SEL") == 0 )
         {
            AV11TFBanSaNombre_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFBanSaNombre_Sels.fromJSonString(AV11TFBanSaNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALDESCRIPCION") == 0 )
         {
            AV15TFBanSalDescripcion = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALDESCRIPCION_SEL") == 0 )
         {
            AV14TFBanSalDescripcion_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFBanSalDescripcion_Sels.fromJSonString(AV14TFBanSalDescripcion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALFRECPAG_SEL") == 0 )
         {
            AV17TFBanSalFrecPag_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFBanSalFrecPag_Sels.fromJSonString(AV17TFBanSalFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALTIPOTARIFA_SEL") == 0 )
         {
            AV19TFBanSalTipoTarifa_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFBanSalTipoTarifa_Sels.fromJSonString(AV19TFBanSalTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADBANSANOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV12TFBanSaNombre = AV34SearchTxt ;
      AV13TFBanSaNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Banda_salarialwwds_1_tfbansanombre = AV12TFBanSaNombre ;
      AV47Banda_salarialwwds_2_tfbansanombre_sels = AV13TFBanSaNombre_Sels ;
      AV48Banda_salarialwwds_3_tfbansaldescripcion = AV15TFBanSalDescripcion ;
      AV49Banda_salarialwwds_4_tfbansaldescripcion_sels = AV16TFBanSalDescripcion_Sels ;
      AV50Banda_salarialwwds_5_tfbansalfrecpag_sels = AV18TFBanSalFrecPag_Sels ;
      AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels = AV20TFBanSalTipoTarifa_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2419BanSaNombre ,
                                           AV47Banda_salarialwwds_2_tfbansanombre_sels ,
                                           A2420BanSalDescripcion ,
                                           AV49Banda_salarialwwds_4_tfbansaldescripcion_sels ,
                                           Byte.valueOf(A2421BanSalFrecPag) ,
                                           AV50Banda_salarialwwds_5_tfbansalfrecpag_sels ,
                                           A2422BanSalTipoTarifa ,
                                           AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels ,
                                           Integer.valueOf(AV47Banda_salarialwwds_2_tfbansanombre_sels.size()) ,
                                           AV46Banda_salarialwwds_1_tfbansanombre ,
                                           Integer.valueOf(AV49Banda_salarialwwds_4_tfbansaldescripcion_sels.size()) ,
                                           AV48Banda_salarialwwds_3_tfbansaldescripcion ,
                                           Integer.valueOf(AV50Banda_salarialwwds_5_tfbansalfrecpag_sels.size()) ,
                                           Integer.valueOf(AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV40EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV46Banda_salarialwwds_1_tfbansanombre = GXutil.concat( GXutil.rtrim( AV46Banda_salarialwwds_1_tfbansanombre), "%", "") ;
      lV48Banda_salarialwwds_3_tfbansaldescripcion = GXutil.concat( GXutil.rtrim( AV48Banda_salarialwwds_3_tfbansaldescripcion), "%", "") ;
      /* Using cursor P02LJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV40EmpCod), lV46Banda_salarialwwds_1_tfbansanombre, lV48Banda_salarialwwds_3_tfbansaldescripcion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2LJ2 = false ;
         A3CliCod = P02LJ2_A3CliCod[0] ;
         A1EmpCod = P02LJ2_A1EmpCod[0] ;
         A2419BanSaNombre = P02LJ2_A2419BanSaNombre[0] ;
         A2422BanSalTipoTarifa = P02LJ2_A2422BanSalTipoTarifa[0] ;
         A2421BanSalFrecPag = P02LJ2_A2421BanSalFrecPag[0] ;
         A2420BanSalDescripcion = P02LJ2_A2420BanSalDescripcion[0] ;
         A2418BanSalCod = P02LJ2_A2418BanSalCod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P02LJ2_A2419BanSaNombre[0], A2419BanSaNombre) == 0 ) )
         {
            brk2LJ2 = false ;
            A3CliCod = P02LJ2_A3CliCod[0] ;
            A1EmpCod = P02LJ2_A1EmpCod[0] ;
            A2418BanSalCod = P02LJ2_A2418BanSalCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk2LJ2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2419BanSaNombre)==0) )
         {
            AV22Option = A2419BanSaNombre ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2LJ2 )
         {
            brk2LJ2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADBANSALDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFBanSalDescripcion = AV34SearchTxt ;
      AV16TFBanSalDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Banda_salarialwwds_1_tfbansanombre = AV12TFBanSaNombre ;
      AV47Banda_salarialwwds_2_tfbansanombre_sels = AV13TFBanSaNombre_Sels ;
      AV48Banda_salarialwwds_3_tfbansaldescripcion = AV15TFBanSalDescripcion ;
      AV49Banda_salarialwwds_4_tfbansaldescripcion_sels = AV16TFBanSalDescripcion_Sels ;
      AV50Banda_salarialwwds_5_tfbansalfrecpag_sels = AV18TFBanSalFrecPag_Sels ;
      AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels = AV20TFBanSalTipoTarifa_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2419BanSaNombre ,
                                           AV47Banda_salarialwwds_2_tfbansanombre_sels ,
                                           A2420BanSalDescripcion ,
                                           AV49Banda_salarialwwds_4_tfbansaldescripcion_sels ,
                                           Byte.valueOf(A2421BanSalFrecPag) ,
                                           AV50Banda_salarialwwds_5_tfbansalfrecpag_sels ,
                                           A2422BanSalTipoTarifa ,
                                           AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels ,
                                           Integer.valueOf(AV47Banda_salarialwwds_2_tfbansanombre_sels.size()) ,
                                           AV46Banda_salarialwwds_1_tfbansanombre ,
                                           Integer.valueOf(AV49Banda_salarialwwds_4_tfbansaldescripcion_sels.size()) ,
                                           AV48Banda_salarialwwds_3_tfbansaldescripcion ,
                                           Integer.valueOf(AV50Banda_salarialwwds_5_tfbansalfrecpag_sels.size()) ,
                                           Integer.valueOf(AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV40EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV46Banda_salarialwwds_1_tfbansanombre = GXutil.concat( GXutil.rtrim( AV46Banda_salarialwwds_1_tfbansanombre), "%", "") ;
      lV48Banda_salarialwwds_3_tfbansaldescripcion = GXutil.concat( GXutil.rtrim( AV48Banda_salarialwwds_3_tfbansaldescripcion), "%", "") ;
      /* Using cursor P02LJ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV40EmpCod), lV46Banda_salarialwwds_1_tfbansanombre, lV48Banda_salarialwwds_3_tfbansaldescripcion});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2LJ4 = false ;
         A3CliCod = P02LJ3_A3CliCod[0] ;
         A1EmpCod = P02LJ3_A1EmpCod[0] ;
         A2420BanSalDescripcion = P02LJ3_A2420BanSalDescripcion[0] ;
         A2422BanSalTipoTarifa = P02LJ3_A2422BanSalTipoTarifa[0] ;
         A2421BanSalFrecPag = P02LJ3_A2421BanSalFrecPag[0] ;
         A2419BanSaNombre = P02LJ3_A2419BanSaNombre[0] ;
         A2418BanSalCod = P02LJ3_A2418BanSalCod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P02LJ3_A2420BanSalDescripcion[0], A2420BanSalDescripcion) == 0 ) )
         {
            brk2LJ4 = false ;
            A3CliCod = P02LJ3_A3CliCod[0] ;
            A1EmpCod = P02LJ3_A1EmpCod[0] ;
            A2418BanSalCod = P02LJ3_A2418BanSalCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk2LJ4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2420BanSalDescripcion)==0) )
         {
            AV22Option = A2420BanSalDescripcion ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2LJ4 )
         {
            brk2LJ4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = banda_salarialwwgetfilterdata.this.AV36OptionsJson;
      this.aP4[0] = banda_salarialwwgetfilterdata.this.AV37OptionsDescJson;
      this.aP5[0] = banda_salarialwwgetfilterdata.this.AV38OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV36OptionsJson = "" ;
      AV37OptionsDescJson = "" ;
      AV38OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFBanSaNombre = "" ;
      AV11TFBanSaNombre_SelsJson = "" ;
      AV13TFBanSaNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFBanSalDescripcion = "" ;
      AV14TFBanSalDescripcion_SelsJson = "" ;
      AV16TFBanSalDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFBanSalFrecPag_SelsJson = "" ;
      AV18TFBanSalFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV19TFBanSalTipoTarifa_SelsJson = "" ;
      AV20TFBanSalTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      A2419BanSaNombre = "" ;
      AV46Banda_salarialwwds_1_tfbansanombre = "" ;
      AV47Banda_salarialwwds_2_tfbansanombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48Banda_salarialwwds_3_tfbansaldescripcion = "" ;
      AV49Banda_salarialwwds_4_tfbansaldescripcion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Banda_salarialwwds_5_tfbansalfrecpag_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV46Banda_salarialwwds_1_tfbansanombre = "" ;
      lV48Banda_salarialwwds_3_tfbansaldescripcion = "" ;
      A2420BanSalDescripcion = "" ;
      A2422BanSalTipoTarifa = "" ;
      P02LJ2_A3CliCod = new int[1] ;
      P02LJ2_A1EmpCod = new short[1] ;
      P02LJ2_A2419BanSaNombre = new String[] {""} ;
      P02LJ2_A2422BanSalTipoTarifa = new String[] {""} ;
      P02LJ2_A2421BanSalFrecPag = new byte[1] ;
      P02LJ2_A2420BanSalDescripcion = new String[] {""} ;
      P02LJ2_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      A2418BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      AV22Option = "" ;
      P02LJ3_A3CliCod = new int[1] ;
      P02LJ3_A1EmpCod = new short[1] ;
      P02LJ3_A2420BanSalDescripcion = new String[] {""} ;
      P02LJ3_A2422BanSalTipoTarifa = new String[] {""} ;
      P02LJ3_A2421BanSalFrecPag = new byte[1] ;
      P02LJ3_A2419BanSaNombre = new String[] {""} ;
      P02LJ3_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.banda_salarialwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02LJ2_A3CliCod, P02LJ2_A1EmpCod, P02LJ2_A2419BanSaNombre, P02LJ2_A2422BanSalTipoTarifa, P02LJ2_A2421BanSalFrecPag, P02LJ2_A2420BanSalDescripcion, P02LJ2_A2418BanSalCod
            }
            , new Object[] {
            P02LJ3_A3CliCod, P02LJ3_A1EmpCod, P02LJ3_A2420BanSalDescripcion, P02LJ3_A2422BanSalTipoTarifa, P02LJ3_A2421BanSalFrecPag, P02LJ3_A2419BanSaNombre, P02LJ3_A2418BanSalCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2421BanSalFrecPag ;
   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV44GXV1 ;
   private int AV47Banda_salarialwwds_2_tfbansanombre_sels_size ;
   private int AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size ;
   private int AV50Banda_salarialwwds_5_tfbansalfrecpag_sels_size ;
   private int AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels_size ;
   private int A3CliCod ;
   private long AV27count ;
   private String scmdbuf ;
   private String A2422BanSalTipoTarifa ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk2LJ2 ;
   private boolean brk2LJ4 ;
   private String AV36OptionsJson ;
   private String AV37OptionsDescJson ;
   private String AV38OptionIndexesJson ;
   private String AV11TFBanSaNombre_SelsJson ;
   private String AV14TFBanSalDescripcion_SelsJson ;
   private String AV17TFBanSalFrecPag_SelsJson ;
   private String AV19TFBanSalTipoTarifa_SelsJson ;
   private String A2420BanSalDescripcion ;
   private String AV33DDOName ;
   private String AV34SearchTxt ;
   private String AV35SearchTxtTo ;
   private String AV12TFBanSaNombre ;
   private String AV15TFBanSalDescripcion ;
   private String AV39MenuOpcCod ;
   private String A2419BanSaNombre ;
   private String AV46Banda_salarialwwds_1_tfbansanombre ;
   private String AV48Banda_salarialwwds_3_tfbansaldescripcion ;
   private String lV46Banda_salarialwwds_1_tfbansanombre ;
   private String lV48Banda_salarialwwds_3_tfbansaldescripcion ;
   private String AV22Option ;
   private java.util.UUID A2418BanSalCod ;
   private GXSimpleCollection<Byte> AV18TFBanSalFrecPag_Sels ;
   private GXSimpleCollection<Byte> AV50Banda_salarialwwds_5_tfbansalfrecpag_sels ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02LJ2_A3CliCod ;
   private short[] P02LJ2_A1EmpCod ;
   private String[] P02LJ2_A2419BanSaNombre ;
   private String[] P02LJ2_A2422BanSalTipoTarifa ;
   private byte[] P02LJ2_A2421BanSalFrecPag ;
   private String[] P02LJ2_A2420BanSalDescripcion ;
   private java.util.UUID[] P02LJ2_A2418BanSalCod ;
   private int[] P02LJ3_A3CliCod ;
   private short[] P02LJ3_A1EmpCod ;
   private String[] P02LJ3_A2420BanSalDescripcion ;
   private String[] P02LJ3_A2422BanSalTipoTarifa ;
   private byte[] P02LJ3_A2421BanSalFrecPag ;
   private String[] P02LJ3_A2419BanSaNombre ;
   private java.util.UUID[] P02LJ3_A2418BanSalCod ;
   private GXSimpleCollection<String> AV20TFBanSalTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV13TFBanSaNombre_Sels ;
   private GXSimpleCollection<String> AV16TFBanSalDescripcion_Sels ;
   private GXSimpleCollection<String> AV47Banda_salarialwwds_2_tfbansanombre_sels ;
   private GXSimpleCollection<String> AV49Banda_salarialwwds_4_tfbansaldescripcion_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class banda_salarialwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02LJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2419BanSaNombre ,
                                          GXSimpleCollection<String> AV47Banda_salarialwwds_2_tfbansanombre_sels ,
                                          String A2420BanSalDescripcion ,
                                          GXSimpleCollection<String> AV49Banda_salarialwwds_4_tfbansaldescripcion_sels ,
                                          byte A2421BanSalFrecPag ,
                                          GXSimpleCollection<Byte> AV50Banda_salarialwwds_5_tfbansalfrecpag_sels ,
                                          String A2422BanSalTipoTarifa ,
                                          GXSimpleCollection<String> AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels ,
                                          int AV47Banda_salarialwwds_2_tfbansanombre_sels_size ,
                                          String AV46Banda_salarialwwds_1_tfbansanombre ,
                                          int AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size ,
                                          String AV48Banda_salarialwwds_3_tfbansaldescripcion ,
                                          int AV50Banda_salarialwwds_5_tfbansalfrecpag_sels_size ,
                                          int AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels_size ,
                                          int A3CliCod ,
                                          int AV41CliCod ,
                                          short A1EmpCod ,
                                          short AV40EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, BanSaNombre, BanSalTipoTarifa, BanSalFrecPag, BanSalDescripcion, BanSalCod FROM banda_salarial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ( AV47Banda_salarialwwds_2_tfbansanombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Banda_salarialwwds_1_tfbansanombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanSaNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV47Banda_salarialwwds_2_tfbansanombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Banda_salarialwwds_2_tfbansanombre_sels, "BanSaNombre IN (", ")")+")");
      }
      if ( ( AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Banda_salarialwwds_3_tfbansaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanSalDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Banda_salarialwwds_4_tfbansaldescripcion_sels, "BanSalDescripcion IN (", ")")+")");
      }
      if ( AV50Banda_salarialwwds_5_tfbansalfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Banda_salarialwwds_5_tfbansalfrecpag_sels, "BanSalFrecPag IN (", ")")+")");
      }
      if ( AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels, "BanSalTipoTarifa IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY BanSaNombre" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02LJ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2419BanSaNombre ,
                                          GXSimpleCollection<String> AV47Banda_salarialwwds_2_tfbansanombre_sels ,
                                          String A2420BanSalDescripcion ,
                                          GXSimpleCollection<String> AV49Banda_salarialwwds_4_tfbansaldescripcion_sels ,
                                          byte A2421BanSalFrecPag ,
                                          GXSimpleCollection<Byte> AV50Banda_salarialwwds_5_tfbansalfrecpag_sels ,
                                          String A2422BanSalTipoTarifa ,
                                          GXSimpleCollection<String> AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels ,
                                          int AV47Banda_salarialwwds_2_tfbansanombre_sels_size ,
                                          String AV46Banda_salarialwwds_1_tfbansanombre ,
                                          int AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size ,
                                          String AV48Banda_salarialwwds_3_tfbansaldescripcion ,
                                          int AV50Banda_salarialwwds_5_tfbansalfrecpag_sels_size ,
                                          int AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels_size ,
                                          int A3CliCod ,
                                          int AV41CliCod ,
                                          short A1EmpCod ,
                                          short AV40EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, BanSalDescripcion, BanSalTipoTarifa, BanSalFrecPag, BanSaNombre, BanSalCod FROM banda_salarial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ( AV47Banda_salarialwwds_2_tfbansanombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Banda_salarialwwds_1_tfbansanombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanSaNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV47Banda_salarialwwds_2_tfbansanombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Banda_salarialwwds_2_tfbansanombre_sels, "BanSaNombre IN (", ")")+")");
      }
      if ( ( AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Banda_salarialwwds_3_tfbansaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanSalDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV49Banda_salarialwwds_4_tfbansaldescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Banda_salarialwwds_4_tfbansaldescripcion_sels, "BanSalDescripcion IN (", ")")+")");
      }
      if ( AV50Banda_salarialwwds_5_tfbansalfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Banda_salarialwwds_5_tfbansalfrecpag_sels, "BanSalFrecPag IN (", ")")+")");
      }
      if ( AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Banda_salarialwwds_6_tfbansaltipotarifa_sels, "BanSalTipoTarifa IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY BanSalDescripcion" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P02LJ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() );
            case 1 :
                  return conditional_P02LJ3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02LJ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((java.util.UUID[]) buf[6])[0] = rslt.getGUID(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.UUID[]) buf[6])[0] = rslt.getGUID(7);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 200);
               }
               return;
      }
   }

}


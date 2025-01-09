package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_tiposdetrabajowwgetfilterdata extends GXProcedure
{
   public convenio_tiposdetrabajowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_tiposdetrabajowwgetfilterdata.class ), "" );
   }

   public convenio_tiposdetrabajowwgetfilterdata( int remoteHandle ,
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
      convenio_tiposdetrabajowwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_tiposdetrabajowwgetfilterdata.this.AV44DDOName = aP0;
      convenio_tiposdetrabajowwgetfilterdata.this.AV45SearchTxt = aP1;
      convenio_tiposdetrabajowwgetfilterdata.this.AV46SearchTxtTo = aP2;
      convenio_tiposdetrabajowwgetfilterdata.this.aP3 = aP3;
      convenio_tiposdetrabajowwgetfilterdata.this.aP4 = aP4;
      convenio_tiposdetrabajowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV51EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      convenio_tiposdetrabajowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV51EmpCod = GXt_int1 ;
      GXt_int3 = AV52CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_tiposdetrabajowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV52CliCod = GXt_int3 ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_tiposdetrabajo", GXv_boolean6) ;
      convenio_tiposdetrabajowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_CONVEHSRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEHSRELREFOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV47OptionsJson = AV34Options.toJSonString(false) ;
      AV48OptionsDescJson = AV36OptionsDesc.toJSonString(false) ;
      AV49OptionIndexesJson = AV37OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV39Session.getValue("convenio_tiposdetrabajoWWGridState"), "") == 0 )
      {
         AV41GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_tiposdetrabajoWWGridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV39Session.getValue("convenio_tiposdetrabajoWWGridState"), null, null);
      }
      AV57GXV1 = 1 ;
      while ( AV57GXV1 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV57GXV1));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV11TFPaiTipoTraId_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFPaiTipoTraId_Sels.fromJSonString(AV11TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSDIA") == 0 )
         {
            AV13TFConveHsDia = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV14TFConveHsDia_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSSEM") == 0 )
         {
            AV15TFConveHsSem = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV16TFConveHsSem_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXDIA") == 0 )
         {
            AV21TFConveHsMaxDia = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV22TFConveHsMaxDia_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXSEM") == 0 )
         {
            AV23TFConveHsMaxSem = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV24TFConveHsMaxSem_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXMES") == 0 )
         {
            AV25TFConveHsMaxMes = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV26TFConveHsMaxMes_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXANU") == 0 )
         {
            AV27TFConveHsMaxAnu = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV28TFConveHsMaxAnu_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSRELREF") == 0 )
         {
            AV30TFConveHsRelRef = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSRELREF_SEL") == 0 )
         {
            AV29TFConveHsRelRef_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV31TFConveHsRelRef_Sels.fromJSonString(AV29TFConveHsRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV50MenuOpcCod = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV57GXV1 = (int)(AV57GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEHSRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV30TFConveHsRelRef = AV45SearchTxt ;
      AV31TFConveHsRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV12TFPaiTipoTraId_Sels ;
      AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV13TFConveHsDia ;
      AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV14TFConveHsDia_To ;
      AV62Convenio_tiposdetrabajowwds_4_tfconvehssem = AV15TFConveHsSem ;
      AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV16TFConveHsSem_To ;
      AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV21TFConveHsMaxDia ;
      AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV22TFConveHsMaxDia_To ;
      AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV23TFConveHsMaxSem ;
      AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV24TFConveHsMaxSem_To ;
      AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV25TFConveHsMaxMes ;
      AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV26TFConveHsMaxMes_To ;
      AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV27TFConveHsMaxAnu ;
      AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV28TFConveHsMaxAnu_To ;
      AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV30TFConveHsRelRef ;
      AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV31TFConveHsRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                           A2064ConveHsRelRef ,
                                           AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                           Integer.valueOf(AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                           AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                           AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                           AV62Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                           AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                           AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                           AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                           AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                           AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                           AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                           AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                           AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                           AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                           Integer.valueOf(AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels.size()) ,
                                           AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                           A1323ConveHsDia ,
                                           A1324ConveHsSem ,
                                           A1391ConveHsMaxDia ,
                                           A1392ConveHsMaxSem ,
                                           A1393ConveHsMaxMes ,
                                           A1394ConveHsMaxAnu ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV53PaiCod) ,
                                           A1565CliConvenio ,
                                           AV54CliConvenio ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV52CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref = GXutil.concat( GXutil.rtrim( AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref), "%", "") ;
      /* Using cursor P01XA2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV53PaiCod), AV54CliConvenio, Integer.valueOf(AV52CliCod), AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia, AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to, AV62Convenio_tiposdetrabajowwds_4_tfconvehssem, AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to, AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia, AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to, AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem, AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to, AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes, AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to, AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu, AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to, lV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1XA2 = false ;
         A1564CliPaiConve = P01XA2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01XA2_A1565CliConvenio[0] ;
         A3CliCod = P01XA2_A3CliCod[0] ;
         A2064ConveHsRelRef = P01XA2_A2064ConveHsRelRef[0] ;
         A1394ConveHsMaxAnu = P01XA2_A1394ConveHsMaxAnu[0] ;
         A1393ConveHsMaxMes = P01XA2_A1393ConveHsMaxMes[0] ;
         A1392ConveHsMaxSem = P01XA2_A1392ConveHsMaxSem[0] ;
         A1391ConveHsMaxDia = P01XA2_A1391ConveHsMaxDia[0] ;
         A1324ConveHsSem = P01XA2_A1324ConveHsSem[0] ;
         A1323ConveHsDia = P01XA2_A1323ConveHsDia[0] ;
         A1294PaiTipoTraId = P01XA2_A1294PaiTipoTraId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01XA2_A2064ConveHsRelRef[0], A2064ConveHsRelRef) == 0 ) )
         {
            brk1XA2 = false ;
            A1564CliPaiConve = P01XA2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01XA2_A1565CliConvenio[0] ;
            A3CliCod = P01XA2_A3CliCod[0] ;
            A1294PaiTipoTraId = P01XA2_A1294PaiTipoTraId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk1XA2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2064ConveHsRelRef)==0) )
         {
            AV33Option = A2064ConveHsRelRef ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1XA2 )
         {
            brk1XA2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_tiposdetrabajowwgetfilterdata.this.AV47OptionsJson;
      this.aP4[0] = convenio_tiposdetrabajowwgetfilterdata.this.AV48OptionsDescJson;
      this.aP5[0] = convenio_tiposdetrabajowwgetfilterdata.this.AV49OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV47OptionsJson = "" ;
      AV48OptionsDescJson = "" ;
      AV49OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV39Session = httpContext.getWebSession();
      AV41GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV42GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFPaiTipoTraId_SelsJson = "" ;
      AV12TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13TFConveHsDia = DecimalUtil.ZERO ;
      AV14TFConveHsDia_To = DecimalUtil.ZERO ;
      AV15TFConveHsSem = DecimalUtil.ZERO ;
      AV16TFConveHsSem_To = DecimalUtil.ZERO ;
      AV21TFConveHsMaxDia = DecimalUtil.ZERO ;
      AV22TFConveHsMaxDia_To = DecimalUtil.ZERO ;
      AV23TFConveHsMaxSem = DecimalUtil.ZERO ;
      AV24TFConveHsMaxSem_To = DecimalUtil.ZERO ;
      AV25TFConveHsMaxMes = DecimalUtil.ZERO ;
      AV26TFConveHsMaxMes_To = DecimalUtil.ZERO ;
      AV27TFConveHsMaxAnu = DecimalUtil.ZERO ;
      AV28TFConveHsMaxAnu_To = DecimalUtil.ZERO ;
      AV30TFConveHsRelRef = "" ;
      AV29TFConveHsRelRef_SelsJson = "" ;
      AV31TFConveHsRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50MenuOpcCod = "" ;
      A2064ConveHsRelRef = "" ;
      AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia = DecimalUtil.ZERO ;
      AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = DecimalUtil.ZERO ;
      AV62Convenio_tiposdetrabajowwds_4_tfconvehssem = DecimalUtil.ZERO ;
      AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to = DecimalUtil.ZERO ;
      AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = DecimalUtil.ZERO ;
      AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = DecimalUtil.ZERO ;
      AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = DecimalUtil.ZERO ;
      AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = DecimalUtil.ZERO ;
      AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = DecimalUtil.ZERO ;
      AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = DecimalUtil.ZERO ;
      AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = DecimalUtil.ZERO ;
      AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = DecimalUtil.ZERO ;
      AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref = "" ;
      AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref = "" ;
      A1294PaiTipoTraId = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      AV54CliConvenio = "" ;
      P01XA2_A1564CliPaiConve = new short[1] ;
      P01XA2_A1565CliConvenio = new String[] {""} ;
      P01XA2_A3CliCod = new int[1] ;
      P01XA2_A2064ConveHsRelRef = new String[] {""} ;
      P01XA2_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XA2_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XA2_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XA2_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XA2_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XA2_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XA2_A1294PaiTipoTraId = new String[] {""} ;
      AV33Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_tiposdetrabajowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01XA2_A1564CliPaiConve, P01XA2_A1565CliConvenio, P01XA2_A3CliCod, P01XA2_A2064ConveHsRelRef, P01XA2_A1394ConveHsMaxAnu, P01XA2_A1393ConveHsMaxMes, P01XA2_A1392ConveHsMaxSem, P01XA2_A1391ConveHsMaxDia, P01XA2_A1324ConveHsSem, P01XA2_A1323ConveHsDia,
            P01XA2_A1294PaiTipoTraId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV51EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short AV53PaiCod ;
   private short Gx_err ;
   private int AV52CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV57GXV1 ;
   private int AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ;
   private int AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ;
   private int A3CliCod ;
   private long AV38count ;
   private java.math.BigDecimal AV13TFConveHsDia ;
   private java.math.BigDecimal AV14TFConveHsDia_To ;
   private java.math.BigDecimal AV15TFConveHsSem ;
   private java.math.BigDecimal AV16TFConveHsSem_To ;
   private java.math.BigDecimal AV21TFConveHsMaxDia ;
   private java.math.BigDecimal AV22TFConveHsMaxDia_To ;
   private java.math.BigDecimal AV23TFConveHsMaxSem ;
   private java.math.BigDecimal AV24TFConveHsMaxSem_To ;
   private java.math.BigDecimal AV25TFConveHsMaxMes ;
   private java.math.BigDecimal AV26TFConveHsMaxMes_To ;
   private java.math.BigDecimal AV27TFConveHsMaxAnu ;
   private java.math.BigDecimal AV28TFConveHsMaxAnu_To ;
   private java.math.BigDecimal AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia ;
   private java.math.BigDecimal AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ;
   private java.math.BigDecimal AV62Convenio_tiposdetrabajowwds_4_tfconvehssem ;
   private java.math.BigDecimal AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to ;
   private java.math.BigDecimal AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ;
   private java.math.BigDecimal AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ;
   private java.math.BigDecimal AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ;
   private java.math.BigDecimal AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ;
   private java.math.BigDecimal AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ;
   private java.math.BigDecimal AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ;
   private java.math.BigDecimal AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ;
   private java.math.BigDecimal AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String A1565CliConvenio ;
   private String AV54CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1XA2 ;
   private String AV47OptionsJson ;
   private String AV48OptionsDescJson ;
   private String AV49OptionIndexesJson ;
   private String AV11TFPaiTipoTraId_SelsJson ;
   private String AV29TFConveHsRelRef_SelsJson ;
   private String AV44DDOName ;
   private String AV45SearchTxt ;
   private String AV46SearchTxtTo ;
   private String AV30TFConveHsRelRef ;
   private String AV50MenuOpcCod ;
   private String A2064ConveHsRelRef ;
   private String AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref ;
   private String lV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref ;
   private String AV33Option ;
   private com.genexus.webpanels.WebSession AV39Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P01XA2_A1564CliPaiConve ;
   private String[] P01XA2_A1565CliConvenio ;
   private int[] P01XA2_A3CliCod ;
   private String[] P01XA2_A2064ConveHsRelRef ;
   private java.math.BigDecimal[] P01XA2_A1394ConveHsMaxAnu ;
   private java.math.BigDecimal[] P01XA2_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] P01XA2_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] P01XA2_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] P01XA2_A1324ConveHsSem ;
   private java.math.BigDecimal[] P01XA2_A1323ConveHsDia ;
   private String[] P01XA2_A1294PaiTipoTraId ;
   private GXSimpleCollection<String> AV12TFPaiTipoTraId_Sels ;
   private GXSimpleCollection<String> AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV36OptionsDesc ;
   private GXSimpleCollection<String> AV37OptionIndexes ;
   private GXSimpleCollection<String> AV31TFConveHsRelRef_Sels ;
   private GXSimpleCollection<String> AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
}

final  class convenio_tiposdetrabajowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01XA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                          String A2064ConveHsRelRef ,
                                          GXSimpleCollection<String> AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                          int AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ,
                                          java.math.BigDecimal AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                          java.math.BigDecimal AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                          java.math.BigDecimal AV62Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                          java.math.BigDecimal AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                          java.math.BigDecimal AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                          java.math.BigDecimal AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                          java.math.BigDecimal AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                          java.math.BigDecimal AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                          java.math.BigDecimal AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                          java.math.BigDecimal AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                          java.math.BigDecimal AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                          java.math.BigDecimal AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                          int AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ,
                                          String AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                          java.math.BigDecimal A1323ConveHsDia ,
                                          java.math.BigDecimal A1324ConveHsSem ,
                                          java.math.BigDecimal A1391ConveHsMaxDia ,
                                          java.math.BigDecimal A1392ConveHsMaxSem ,
                                          java.math.BigDecimal A1393ConveHsMaxMes ,
                                          java.math.BigDecimal A1394ConveHsMaxAnu ,
                                          short A1564CliPaiConve ,
                                          short AV53PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV54CliConvenio ,
                                          int A3CliCod ,
                                          int AV52CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[16];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliPaiConve, CliConvenio, CliCod, ConveHsRelRef, ConveHsMaxAnu, ConveHsMaxMes, ConveHsMaxSem, ConveHsMaxDia, ConveHsSem, ConveHsDia, PaiTipoTraId FROM convenio_tiposdetrabajo" ;
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60Convenio_tiposdetrabajowwds_2_tfconvehsdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Convenio_tiposdetrabajowwds_3_tfconvehsdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Convenio_tiposdetrabajowwds_4_tfconvehssem)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63Convenio_tiposdetrabajowwds_5_tfconvehssem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia >= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia <= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem >= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem <= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes >= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes <= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ( AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Convenio_tiposdetrabajowwds_14_tfconvehsrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels, "ConveHsRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveHsRelRef" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01XA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
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
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 1);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 1);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 1);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 40);
               }
               return;
      }
   }

}


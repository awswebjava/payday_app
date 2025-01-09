package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paistipotrabajowwgetfilterdata extends GXProcedure
{
   public paistipotrabajowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajowwgetfilterdata.class ), "" );
   }

   public paistipotrabajowwgetfilterdata( int remoteHandle ,
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
      paistipotrabajowwgetfilterdata.this.aP5 = new String[] {""};
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
      paistipotrabajowwgetfilterdata.this.AV45DDOName = aP0;
      paistipotrabajowwgetfilterdata.this.AV46SearchTxt = aP1;
      paistipotrabajowwgetfilterdata.this.AV47SearchTxtTo = aP2;
      paistipotrabajowwgetfilterdata.this.aP3 = aP3;
      paistipotrabajowwgetfilterdata.this.aP4 = aP4;
      paistipotrabajowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV52EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      paistipotrabajowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV52EmpCod = GXt_int1 ;
      GXt_int3 = AV53CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      paistipotrabajowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV53CliCod = GXt_int3 ;
      AV35Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV38OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo", GXv_boolean6) ;
      paistipotrabajowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV45DDOName), "DDO_PAITIPOTRARELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADPAITIPOTRARELREFOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV48OptionsJson = AV35Options.toJSonString(false) ;
      AV49OptionsDescJson = AV37OptionsDesc.toJSonString(false) ;
      AV50OptionIndexesJson = AV38OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV40Session.getValue("PaisTipoTrabajoWWGridState"), "") == 0 )
      {
         AV42GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisTipoTrabajoWWGridState"), null, null);
      }
      else
      {
         AV42GridState.fromxml(AV40Session.getValue("PaisTipoTrabajoWWGridState"), null, null);
      }
      AV57GXV1 = 1 ;
      while ( AV57GXV1 <= AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV43GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV57GXV1));
         if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV11TFPaiTipoTraId_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFPaiTipoTraId_Sels.fromJSonString(AV11TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAINS_SEL") == 0 )
         {
            AV13TFPaiTipoTraIns_Sel = (byte)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSDIA") == 0 )
         {
            AV14TFPaiTipoHsDia = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV15TFPaiTipoHsDia_To = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSSEM") == 0 )
         {
            AV16TFPaiTipoHsSem = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV17TFPaiTipoHsSem_To = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXDIA") == 0 )
         {
            AV22TFPaiTipoHsMaxDia = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV23TFPaiTipoHsMaxDia_To = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXSEM") == 0 )
         {
            AV24TFPaiTipoHsMaxSem = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV25TFPaiTipoHsMaxSem_To = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXMES_SEL") == 0 )
         {
            AV26TFPaiTipoHsMaxMes_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFPaiTipoHsMaxMes_Sels.fromJSonString(AV26TFPaiTipoHsMaxMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXANU") == 0 )
         {
            AV28TFPaiTipoHsMaxAnu = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV29TFPaiTipoHsMaxAnu_To = CommonUtil.decimalVal( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRARELREF") == 0 )
         {
            AV31TFPaiTipoTraRelRef = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRARELREF_SEL") == 0 )
         {
            AV30TFPaiTipoTraRelRef_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV32TFPaiTipoTraRelRef_Sels.fromJSonString(AV30TFPaiTipoTraRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV51MenuOpcCod = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV57GXV1 = (int)(AV57GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPAITIPOTRARELREFOPTIONS' Routine */
      returnInSub = false ;
      AV31TFPaiTipoTraRelRef = AV46SearchTxt ;
      AV32TFPaiTipoTraRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Paistipotrabajowwds_1_tfpaitipotraid_sels = AV12TFPaiTipoTraId_Sels ;
      AV60Paistipotrabajowwds_2_tfpaitipotrains_sel = AV13TFPaiTipoTraIns_Sel ;
      AV61Paistipotrabajowwds_3_tfpaitipohsdia = AV14TFPaiTipoHsDia ;
      AV62Paistipotrabajowwds_4_tfpaitipohsdia_to = AV15TFPaiTipoHsDia_To ;
      AV63Paistipotrabajowwds_5_tfpaitipohssem = AV16TFPaiTipoHsSem ;
      AV64Paistipotrabajowwds_6_tfpaitipohssem_to = AV17TFPaiTipoHsSem_To ;
      AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia = AV22TFPaiTipoHsMaxDia ;
      AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to = AV23TFPaiTipoHsMaxDia_To ;
      AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem = AV24TFPaiTipoHsMaxSem ;
      AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to = AV25TFPaiTipoHsMaxSem_To ;
      AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels = AV27TFPaiTipoHsMaxMes_Sels ;
      AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu = AV28TFPaiTipoHsMaxAnu ;
      AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to = AV29TFPaiTipoHsMaxAnu_To ;
      AV72Paistipotrabajowwds_14_tfpaitipotrarelref = AV31TFPaiTipoTraRelRef ;
      AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels = AV32TFPaiTipoTraRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV59Paistipotrabajowwds_1_tfpaitipotraid_sels ,
                                           A1385PaiTipoHsMaxMes ,
                                           AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels ,
                                           A2056PaiTipoTraRelRef ,
                                           AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels ,
                                           Integer.valueOf(AV59Paistipotrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                           Byte.valueOf(AV60Paistipotrabajowwds_2_tfpaitipotrains_sel) ,
                                           AV61Paistipotrabajowwds_3_tfpaitipohsdia ,
                                           AV62Paistipotrabajowwds_4_tfpaitipohsdia_to ,
                                           AV63Paistipotrabajowwds_5_tfpaitipohssem ,
                                           AV64Paistipotrabajowwds_6_tfpaitipohssem_to ,
                                           AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia ,
                                           AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to ,
                                           AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem ,
                                           AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to ,
                                           Integer.valueOf(AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels.size()) ,
                                           AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu ,
                                           AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to ,
                                           Integer.valueOf(AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels.size()) ,
                                           AV72Paistipotrabajowwds_14_tfpaitipotrarelref ,
                                           Short.valueOf(AV54PaiCod) ,
                                           Boolean.valueOf(A1297PaiTipoTraIns) ,
                                           A1336PaiTipoHsDia ,
                                           A1337PaiTipoHsSem ,
                                           A1383PaiTipoHsMaxDia ,
                                           A1384PaiTipoHsMaxSem ,
                                           A1390PaiTipoHsMaxAnu ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT
                                           }
      });
      lV72Paistipotrabajowwds_14_tfpaitipotrarelref = GXutil.concat( GXutil.rtrim( AV72Paistipotrabajowwds_14_tfpaitipotrarelref), "%", "") ;
      /* Using cursor P01X92 */
      pr_default.execute(0, new Object[] {AV61Paistipotrabajowwds_3_tfpaitipohsdia, AV62Paistipotrabajowwds_4_tfpaitipohsdia_to, AV63Paistipotrabajowwds_5_tfpaitipohssem, AV64Paistipotrabajowwds_6_tfpaitipohssem_to, AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia, AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to, AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem, AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to, AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu, AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to, lV72Paistipotrabajowwds_14_tfpaitipotrarelref, Short.valueOf(AV54PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1X92 = false ;
         A2056PaiTipoTraRelRef = P01X92_A2056PaiTipoTraRelRef[0] ;
         A46PaiCod = P01X92_A46PaiCod[0] ;
         A1390PaiTipoHsMaxAnu = P01X92_A1390PaiTipoHsMaxAnu[0] ;
         A1385PaiTipoHsMaxMes = P01X92_A1385PaiTipoHsMaxMes[0] ;
         A1384PaiTipoHsMaxSem = P01X92_A1384PaiTipoHsMaxSem[0] ;
         A1383PaiTipoHsMaxDia = P01X92_A1383PaiTipoHsMaxDia[0] ;
         A1337PaiTipoHsSem = P01X92_A1337PaiTipoHsSem[0] ;
         A1336PaiTipoHsDia = P01X92_A1336PaiTipoHsDia[0] ;
         A1297PaiTipoTraIns = P01X92_A1297PaiTipoTraIns[0] ;
         A1294PaiTipoTraId = P01X92_A1294PaiTipoTraId[0] ;
         AV39count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01X92_A2056PaiTipoTraRelRef[0], A2056PaiTipoTraRelRef) == 0 ) )
         {
            brk1X92 = false ;
            A46PaiCod = P01X92_A46PaiCod[0] ;
            A1294PaiTipoTraId = P01X92_A1294PaiTipoTraId[0] ;
            AV39count = (long)(AV39count+1) ;
            brk1X92 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2056PaiTipoTraRelRef)==0) )
         {
            AV34Option = A2056PaiTipoTraRelRef ;
            AV35Options.add(AV34Option, 0);
            AV38OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV39count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV35Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1X92 )
         {
            brk1X92 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = paistipotrabajowwgetfilterdata.this.AV48OptionsJson;
      this.aP4[0] = paistipotrabajowwgetfilterdata.this.AV49OptionsDescJson;
      this.aP5[0] = paistipotrabajowwgetfilterdata.this.AV50OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV48OptionsJson = "" ;
      AV49OptionsDescJson = "" ;
      AV50OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV35Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV40Session = httpContext.getWebSession();
      AV42GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV43GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFPaiTipoTraId_SelsJson = "" ;
      AV12TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFPaiTipoHsDia = DecimalUtil.ZERO ;
      AV15TFPaiTipoHsDia_To = DecimalUtil.ZERO ;
      AV16TFPaiTipoHsSem = DecimalUtil.ZERO ;
      AV17TFPaiTipoHsSem_To = DecimalUtil.ZERO ;
      AV22TFPaiTipoHsMaxDia = DecimalUtil.ZERO ;
      AV23TFPaiTipoHsMaxDia_To = DecimalUtil.ZERO ;
      AV24TFPaiTipoHsMaxSem = DecimalUtil.ZERO ;
      AV25TFPaiTipoHsMaxSem_To = DecimalUtil.ZERO ;
      AV26TFPaiTipoHsMaxMes_SelsJson = "" ;
      AV27TFPaiTipoHsMaxMes_Sels = new GXSimpleCollection<java.math.BigDecimal>(java.math.BigDecimal.class, "internal", "");
      AV28TFPaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      AV29TFPaiTipoHsMaxAnu_To = DecimalUtil.ZERO ;
      AV31TFPaiTipoTraRelRef = "" ;
      AV30TFPaiTipoTraRelRef_SelsJson = "" ;
      AV32TFPaiTipoTraRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51MenuOpcCod = "" ;
      A2056PaiTipoTraRelRef = "" ;
      AV59Paistipotrabajowwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Paistipotrabajowwds_3_tfpaitipohsdia = DecimalUtil.ZERO ;
      AV62Paistipotrabajowwds_4_tfpaitipohsdia_to = DecimalUtil.ZERO ;
      AV63Paistipotrabajowwds_5_tfpaitipohssem = DecimalUtil.ZERO ;
      AV64Paistipotrabajowwds_6_tfpaitipohssem_to = DecimalUtil.ZERO ;
      AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia = DecimalUtil.ZERO ;
      AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to = DecimalUtil.ZERO ;
      AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem = DecimalUtil.ZERO ;
      AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to = DecimalUtil.ZERO ;
      AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels = new GXSimpleCollection<java.math.BigDecimal>(java.math.BigDecimal.class, "internal", "");
      AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu = DecimalUtil.ZERO ;
      AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to = DecimalUtil.ZERO ;
      AV72Paistipotrabajowwds_14_tfpaitipotrarelref = "" ;
      AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV72Paistipotrabajowwds_14_tfpaitipotrarelref = "" ;
      A1294PaiTipoTraId = "" ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      P01X92_A2056PaiTipoTraRelRef = new String[] {""} ;
      P01X92_A46PaiCod = new short[1] ;
      P01X92_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X92_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X92_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X92_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X92_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X92_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X92_A1297PaiTipoTraIns = new boolean[] {false} ;
      P01X92_A1294PaiTipoTraId = new String[] {""} ;
      AV34Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paistipotrabajowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01X92_A2056PaiTipoTraRelRef, P01X92_A46PaiCod, P01X92_A1390PaiTipoHsMaxAnu, P01X92_A1385PaiTipoHsMaxMes, P01X92_A1384PaiTipoHsMaxSem, P01X92_A1383PaiTipoHsMaxDia, P01X92_A1337PaiTipoHsSem, P01X92_A1336PaiTipoHsDia, P01X92_A1297PaiTipoTraIns, P01X92_A1294PaiTipoTraId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13TFPaiTipoTraIns_Sel ;
   private byte AV60Paistipotrabajowwds_2_tfpaitipotrains_sel ;
   private short AV52EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV54PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV53CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV57GXV1 ;
   private int AV59Paistipotrabajowwds_1_tfpaitipotraid_sels_size ;
   private int AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels_size ;
   private int AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size ;
   private long AV39count ;
   private java.math.BigDecimal AV14TFPaiTipoHsDia ;
   private java.math.BigDecimal AV15TFPaiTipoHsDia_To ;
   private java.math.BigDecimal AV16TFPaiTipoHsSem ;
   private java.math.BigDecimal AV17TFPaiTipoHsSem_To ;
   private java.math.BigDecimal AV22TFPaiTipoHsMaxDia ;
   private java.math.BigDecimal AV23TFPaiTipoHsMaxDia_To ;
   private java.math.BigDecimal AV24TFPaiTipoHsMaxSem ;
   private java.math.BigDecimal AV25TFPaiTipoHsMaxSem_To ;
   private java.math.BigDecimal AV28TFPaiTipoHsMaxAnu ;
   private java.math.BigDecimal AV29TFPaiTipoHsMaxAnu_To ;
   private java.math.BigDecimal AV61Paistipotrabajowwds_3_tfpaitipohsdia ;
   private java.math.BigDecimal AV62Paistipotrabajowwds_4_tfpaitipohsdia_to ;
   private java.math.BigDecimal AV63Paistipotrabajowwds_5_tfpaitipohssem ;
   private java.math.BigDecimal AV64Paistipotrabajowwds_6_tfpaitipohssem_to ;
   private java.math.BigDecimal AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia ;
   private java.math.BigDecimal AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to ;
   private java.math.BigDecimal AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem ;
   private java.math.BigDecimal AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to ;
   private java.math.BigDecimal AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu ;
   private java.math.BigDecimal AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1297PaiTipoTraIns ;
   private boolean brk1X92 ;
   private String AV48OptionsJson ;
   private String AV49OptionsDescJson ;
   private String AV50OptionIndexesJson ;
   private String AV11TFPaiTipoTraId_SelsJson ;
   private String AV26TFPaiTipoHsMaxMes_SelsJson ;
   private String AV30TFPaiTipoTraRelRef_SelsJson ;
   private String AV45DDOName ;
   private String AV46SearchTxt ;
   private String AV47SearchTxtTo ;
   private String AV31TFPaiTipoTraRelRef ;
   private String AV51MenuOpcCod ;
   private String A2056PaiTipoTraRelRef ;
   private String AV72Paistipotrabajowwds_14_tfpaitipotrarelref ;
   private String lV72Paistipotrabajowwds_14_tfpaitipotrarelref ;
   private String AV34Option ;
   private com.genexus.webpanels.WebSession AV40Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01X92_A2056PaiTipoTraRelRef ;
   private short[] P01X92_A46PaiCod ;
   private java.math.BigDecimal[] P01X92_A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal[] P01X92_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] P01X92_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] P01X92_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] P01X92_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] P01X92_A1336PaiTipoHsDia ;
   private boolean[] P01X92_A1297PaiTipoTraIns ;
   private String[] P01X92_A1294PaiTipoTraId ;
   private GXSimpleCollection<java.math.BigDecimal> AV27TFPaiTipoHsMaxMes_Sels ;
   private GXSimpleCollection<java.math.BigDecimal> AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels ;
   private GXSimpleCollection<String> AV12TFPaiTipoTraId_Sels ;
   private GXSimpleCollection<String> AV59Paistipotrabajowwds_1_tfpaitipotraid_sels ;
   private GXSimpleCollection<String> AV35Options ;
   private GXSimpleCollection<String> AV37OptionsDesc ;
   private GXSimpleCollection<String> AV38OptionIndexes ;
   private GXSimpleCollection<String> AV32TFPaiTipoTraRelRef_Sels ;
   private GXSimpleCollection<String> AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV42GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV43GridStateFilterValue ;
}

final  class paistipotrabajowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01X92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV59Paistipotrabajowwds_1_tfpaitipotraid_sels ,
                                          java.math.BigDecimal A1385PaiTipoHsMaxMes ,
                                          GXSimpleCollection<java.math.BigDecimal> AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels ,
                                          String A2056PaiTipoTraRelRef ,
                                          GXSimpleCollection<String> AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels ,
                                          int AV59Paistipotrabajowwds_1_tfpaitipotraid_sels_size ,
                                          byte AV60Paistipotrabajowwds_2_tfpaitipotrains_sel ,
                                          java.math.BigDecimal AV61Paistipotrabajowwds_3_tfpaitipohsdia ,
                                          java.math.BigDecimal AV62Paistipotrabajowwds_4_tfpaitipohsdia_to ,
                                          java.math.BigDecimal AV63Paistipotrabajowwds_5_tfpaitipohssem ,
                                          java.math.BigDecimal AV64Paistipotrabajowwds_6_tfpaitipohssem_to ,
                                          java.math.BigDecimal AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia ,
                                          java.math.BigDecimal AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to ,
                                          java.math.BigDecimal AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem ,
                                          java.math.BigDecimal AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to ,
                                          int AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels_size ,
                                          java.math.BigDecimal AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu ,
                                          java.math.BigDecimal AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to ,
                                          int AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size ,
                                          String AV72Paistipotrabajowwds_14_tfpaitipotrarelref ,
                                          short AV54PaiCod ,
                                          boolean A1297PaiTipoTraIns ,
                                          java.math.BigDecimal A1336PaiTipoHsDia ,
                                          java.math.BigDecimal A1337PaiTipoHsSem ,
                                          java.math.BigDecimal A1383PaiTipoHsMaxDia ,
                                          java.math.BigDecimal A1384PaiTipoHsMaxSem ,
                                          java.math.BigDecimal A1390PaiTipoHsMaxAnu ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PaiTipoTraRelRef, PaiCod, PaiTipoHsMaxAnu, PaiTipoHsMaxMes, PaiTipoHsMaxSem, PaiTipoHsMaxDia, PaiTipoHsSem, PaiTipoHsDia, PaiTipoTraIns, PaiTipoTraId FROM" ;
      scmdbuf += " PaisTipoTrabajo" ;
      if ( AV59Paistipotrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Paistipotrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( AV60Paistipotrabajowwds_2_tfpaitipotrains_sel == 1 )
      {
         addWhere(sWhereString, "(PaiTipoTraIns = TRUE)");
      }
      if ( AV60Paistipotrabajowwds_2_tfpaitipotrains_sel == 2 )
      {
         addWhere(sWhereString, "(PaiTipoTraIns = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Paistipotrabajowwds_3_tfpaitipohsdia)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsDia >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Paistipotrabajowwds_4_tfpaitipohsdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsDia <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63Paistipotrabajowwds_5_tfpaitipohssem)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsSem >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Paistipotrabajowwds_6_tfpaitipohssem_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsSem <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Paistipotrabajowwds_7_tfpaitipohsmaxdia)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxDia >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Paistipotrabajowwds_8_tfpaitipohsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxDia <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Paistipotrabajowwds_9_tfpaitipohsmaxsem)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxSem >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Paistipotrabajowwds_10_tfpaitipohsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxSem <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels, "PaiTipoHsMaxMes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Paistipotrabajowwds_12_tfpaitipohsmaxanu)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Paistipotrabajowwds_13_tfpaitipohsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ( AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Paistipotrabajowwds_14_tfpaitipotrarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiTipoTraRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Paistipotrabajowwds_15_tfpaitipotrarelref_sels, "PaiTipoTraRelRef IN (", ")")+")");
      }
      if ( ! (0==AV54PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiTipoTraRelRef" ;
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
                  return conditional_P01X92(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.math.BigDecimal)dynConstraints[2] , (GXSimpleCollection<java.math.BigDecimal>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).byteValue() , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X92", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 1);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 1);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 1);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               return;
      }
   }

}


package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verliqretro2getfilterdata extends GXProcedure
{
   public verliqretro2getfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verliqretro2getfilterdata.class ), "" );
   }

   public verliqretro2getfilterdata( int remoteHandle ,
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
      verliqretro2getfilterdata.this.aP5 = new String[] {""};
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
      verliqretro2getfilterdata.this.AV36DDOName = aP0;
      verliqretro2getfilterdata.this.AV37SearchTxt = aP1;
      verliqretro2getfilterdata.this.AV38SearchTxtTo = aP2;
      verliqretro2getfilterdata.this.aP3 = aP3;
      verliqretro2getfilterdata.this.aP4 = aP4;
      verliqretro2getfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_DCONCODIGO") == 0 )
      {
         /* Execute user subroutine: 'LOADDCONCODIGOOPTIONS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_DCONDESCRIP") == 0 )
      {
         /* Execute user subroutine: 'LOADDCONDESCRIPOPTIONS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV39OptionsJson = AV26Options.toJSonString(false) ;
      AV40OptionsDescJson = AV28OptionsDesc.toJSonString(false) ;
      AV41OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("verLiqRetro2GridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "verLiqRetro2GridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("verLiqRetro2GridState"), null, null);
      }
      AV48GXV1 = 1 ;
      while ( AV48GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "DTIPOCONCOD") == 0 )
         {
            AV42DTipoConCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV11TFDTipoConCod_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFDTipoConCod_Sels.fromJSonString(AV11TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV14TFDConCodigo = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV13TFDConCodigo_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFDConCodigo_Sels.fromJSonString(AV13TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV17TFDConDescrip = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV16TFDConDescrip_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFDConDescrip_Sels.fromJSonString(AV16TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV19TFLiqDImpReCalcu = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV20TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV43CliCod = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV44EmpCod = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV45LiqNro = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV48GXV1 = (int)(AV48GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADDCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV14TFDConCodigo = AV37SearchTxt ;
      AV15TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Verliqretro2ds_1_clicod = AV43CliCod ;
      AV51Verliqretro2ds_2_empcod = AV44EmpCod ;
      AV52Verliqretro2ds_3_liqnro = AV45LiqNro ;
      AV53Verliqretro2ds_4_dtipoconcod = AV42DTipoConCod ;
      AV54Verliqretro2ds_5_tfdtipoconcod_sels = AV12TFDTipoConCod_Sels ;
      AV55Verliqretro2ds_6_tfdconcodigo = AV14TFDConCodigo ;
      AV56Verliqretro2ds_7_tfdconcodigo_sels = AV15TFDConCodigo_Sels ;
      AV57Verliqretro2ds_8_tfdcondescrip = AV17TFDConDescrip ;
      AV58Verliqretro2ds_9_tfdcondescrip_sels = AV18TFDConDescrip_Sels ;
      AV59Verliqretro2ds_10_tfliqdimprecalcu = AV19TFLiqDImpReCalcu ;
      AV60Verliqretro2ds_11_tfliqdimprecalcu_to = AV20TFLiqDImpReCalcu_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV54Verliqretro2ds_5_tfdtipoconcod_sels ,
                                           A394DConCodigo ,
                                           AV56Verliqretro2ds_7_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV58Verliqretro2ds_9_tfdcondescrip_sels ,
                                           Integer.valueOf(AV54Verliqretro2ds_5_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV56Verliqretro2ds_7_tfdconcodigo_sels.size()) ,
                                           AV55Verliqretro2ds_6_tfdconcodigo ,
                                           Integer.valueOf(AV58Verliqretro2ds_9_tfdcondescrip_sels.size()) ,
                                           AV57Verliqretro2ds_8_tfdcondescrip ,
                                           AV59Verliqretro2ds_10_tfliqdimprecalcu ,
                                           AV60Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV50Verliqretro2ds_1_clicod) ,
                                           Short.valueOf(AV51Verliqretro2ds_2_empcod) ,
                                           Integer.valueOf(AV52Verliqretro2ds_3_liqnro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV55Verliqretro2ds_6_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV55Verliqretro2ds_6_tfdconcodigo), 10, "%") ;
      lV57Verliqretro2ds_8_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV57Verliqretro2ds_8_tfdcondescrip), "%", "") ;
      /* Using cursor P020M2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV50Verliqretro2ds_1_clicod), Short.valueOf(AV51Verliqretro2ds_2_empcod), Integer.valueOf(AV52Verliqretro2ds_3_liqnro), lV55Verliqretro2ds_6_tfdconcodigo, lV57Verliqretro2ds_8_tfdcondescrip, AV59Verliqretro2ds_10_tfliqdimprecalcu, AV60Verliqretro2ds_11_tfliqdimprecalcu_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk20M2 = false ;
         A3CliCod = P020M2_A3CliCod[0] ;
         A1EmpCod = P020M2_A1EmpCod[0] ;
         A31LiqNro = P020M2_A31LiqNro[0] ;
         A394DConCodigo = P020M2_A394DConCodigo[0] ;
         A764LiqDImpReCalcu = P020M2_A764LiqDImpReCalcu[0] ;
         A393DConDescrip = P020M2_A393DConDescrip[0] ;
         A464DTipoConCod = P020M2_A464DTipoConCod[0] ;
         A6LegNumero = P020M2_A6LegNumero[0] ;
         A81LiqDSecuencial = P020M2_A81LiqDSecuencial[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P020M2_A3CliCod[0] == A3CliCod ) && ( P020M2_A1EmpCod[0] == A1EmpCod ) && ( P020M2_A31LiqNro[0] == A31LiqNro ) && ( GXutil.strcmp(P020M2_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            brk20M2 = false ;
            A6LegNumero = P020M2_A6LegNumero[0] ;
            A81LiqDSecuencial = P020M2_A81LiqDSecuencial[0] ;
            AV30count = (long)(AV30count+1) ;
            brk20M2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A394DConCodigo)==0) )
         {
            AV25Option = A394DConCodigo ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20M2 )
         {
            brk20M2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADDCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV17TFDConDescrip = AV37SearchTxt ;
      AV18TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Verliqretro2ds_1_clicod = AV43CliCod ;
      AV51Verliqretro2ds_2_empcod = AV44EmpCod ;
      AV52Verliqretro2ds_3_liqnro = AV45LiqNro ;
      AV53Verliqretro2ds_4_dtipoconcod = AV42DTipoConCod ;
      AV54Verliqretro2ds_5_tfdtipoconcod_sels = AV12TFDTipoConCod_Sels ;
      AV55Verliqretro2ds_6_tfdconcodigo = AV14TFDConCodigo ;
      AV56Verliqretro2ds_7_tfdconcodigo_sels = AV15TFDConCodigo_Sels ;
      AV57Verliqretro2ds_8_tfdcondescrip = AV17TFDConDescrip ;
      AV58Verliqretro2ds_9_tfdcondescrip_sels = AV18TFDConDescrip_Sels ;
      AV59Verliqretro2ds_10_tfliqdimprecalcu = AV19TFLiqDImpReCalcu ;
      AV60Verliqretro2ds_11_tfliqdimprecalcu_to = AV20TFLiqDImpReCalcu_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV54Verliqretro2ds_5_tfdtipoconcod_sels ,
                                           A394DConCodigo ,
                                           AV56Verliqretro2ds_7_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV58Verliqretro2ds_9_tfdcondescrip_sels ,
                                           Integer.valueOf(AV54Verliqretro2ds_5_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV56Verliqretro2ds_7_tfdconcodigo_sels.size()) ,
                                           AV55Verliqretro2ds_6_tfdconcodigo ,
                                           Integer.valueOf(AV58Verliqretro2ds_9_tfdcondescrip_sels.size()) ,
                                           AV57Verliqretro2ds_8_tfdcondescrip ,
                                           AV59Verliqretro2ds_10_tfliqdimprecalcu ,
                                           AV60Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV50Verliqretro2ds_1_clicod) ,
                                           Short.valueOf(AV51Verliqretro2ds_2_empcod) ,
                                           Integer.valueOf(AV52Verliqretro2ds_3_liqnro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV55Verliqretro2ds_6_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV55Verliqretro2ds_6_tfdconcodigo), 10, "%") ;
      lV57Verliqretro2ds_8_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV57Verliqretro2ds_8_tfdcondescrip), "%", "") ;
      /* Using cursor P020M3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV50Verliqretro2ds_1_clicod), Short.valueOf(AV51Verliqretro2ds_2_empcod), Integer.valueOf(AV52Verliqretro2ds_3_liqnro), lV55Verliqretro2ds_6_tfdconcodigo, lV57Verliqretro2ds_8_tfdcondescrip, AV59Verliqretro2ds_10_tfliqdimprecalcu, AV60Verliqretro2ds_11_tfliqdimprecalcu_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk20M4 = false ;
         A3CliCod = P020M3_A3CliCod[0] ;
         A1EmpCod = P020M3_A1EmpCod[0] ;
         A31LiqNro = P020M3_A31LiqNro[0] ;
         A393DConDescrip = P020M3_A393DConDescrip[0] ;
         A764LiqDImpReCalcu = P020M3_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P020M3_A394DConCodigo[0] ;
         A464DTipoConCod = P020M3_A464DTipoConCod[0] ;
         A6LegNumero = P020M3_A6LegNumero[0] ;
         A81LiqDSecuencial = P020M3_A81LiqDSecuencial[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P020M3_A3CliCod[0] == A3CliCod ) && ( P020M3_A1EmpCod[0] == A1EmpCod ) && ( P020M3_A31LiqNro[0] == A31LiqNro ) && ( GXutil.strcmp(P020M3_A393DConDescrip[0], A393DConDescrip) == 0 ) )
         {
            brk20M4 = false ;
            A6LegNumero = P020M3_A6LegNumero[0] ;
            A81LiqDSecuencial = P020M3_A81LiqDSecuencial[0] ;
            AV30count = (long)(AV30count+1) ;
            brk20M4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A393DConDescrip)==0) )
         {
            AV25Option = A393DConDescrip ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20M4 )
         {
            brk20M4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = verliqretro2getfilterdata.this.AV39OptionsJson;
      this.aP4[0] = verliqretro2getfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = verliqretro2getfilterdata.this.AV41OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV39OptionsJson = "" ;
      AV40OptionsDescJson = "" ;
      AV41OptionIndexesJson = "" ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV42DTipoConCod = "" ;
      AV11TFDTipoConCod_SelsJson = "" ;
      AV12TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFDConCodigo = "" ;
      AV13TFDConCodigo_SelsJson = "" ;
      AV15TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFDConDescrip = "" ;
      AV16TFDConDescrip_SelsJson = "" ;
      AV18TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV20TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      AV53Verliqretro2ds_4_dtipoconcod = "" ;
      AV54Verliqretro2ds_5_tfdtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Verliqretro2ds_6_tfdconcodigo = "" ;
      AV56Verliqretro2ds_7_tfdconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Verliqretro2ds_8_tfdcondescrip = "" ;
      AV58Verliqretro2ds_9_tfdcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Verliqretro2ds_10_tfliqdimprecalcu = DecimalUtil.ZERO ;
      AV60Verliqretro2ds_11_tfliqdimprecalcu_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV55Verliqretro2ds_6_tfdconcodigo = "" ;
      lV57Verliqretro2ds_8_tfdcondescrip = "" ;
      A464DTipoConCod = "" ;
      A393DConDescrip = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      P020M2_A3CliCod = new int[1] ;
      P020M2_A1EmpCod = new short[1] ;
      P020M2_A31LiqNro = new int[1] ;
      P020M2_A394DConCodigo = new String[] {""} ;
      P020M2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P020M2_A393DConDescrip = new String[] {""} ;
      P020M2_A464DTipoConCod = new String[] {""} ;
      P020M2_A6LegNumero = new int[1] ;
      P020M2_A81LiqDSecuencial = new int[1] ;
      AV25Option = "" ;
      P020M3_A3CliCod = new int[1] ;
      P020M3_A1EmpCod = new short[1] ;
      P020M3_A31LiqNro = new int[1] ;
      P020M3_A393DConDescrip = new String[] {""} ;
      P020M3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P020M3_A394DConCodigo = new String[] {""} ;
      P020M3_A464DTipoConCod = new String[] {""} ;
      P020M3_A6LegNumero = new int[1] ;
      P020M3_A81LiqDSecuencial = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.verliqretro2getfilterdata__default(),
         new Object[] {
             new Object[] {
            P020M2_A3CliCod, P020M2_A1EmpCod, P020M2_A31LiqNro, P020M2_A394DConCodigo, P020M2_A764LiqDImpReCalcu, P020M2_A393DConDescrip, P020M2_A464DTipoConCod, P020M2_A6LegNumero, P020M2_A81LiqDSecuencial
            }
            , new Object[] {
            P020M3_A3CliCod, P020M3_A1EmpCod, P020M3_A31LiqNro, P020M3_A393DConDescrip, P020M3_A764LiqDImpReCalcu, P020M3_A394DConCodigo, P020M3_A464DTipoConCod, P020M3_A6LegNumero, P020M3_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV44EmpCod ;
   private short AV51Verliqretro2ds_2_empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV48GXV1 ;
   private int AV43CliCod ;
   private int AV45LiqNro ;
   private int AV50Verliqretro2ds_1_clicod ;
   private int AV52Verliqretro2ds_3_liqnro ;
   private int AV54Verliqretro2ds_5_tfdtipoconcod_sels_size ;
   private int AV56Verliqretro2ds_7_tfdconcodigo_sels_size ;
   private int AV58Verliqretro2ds_9_tfdcondescrip_sels_size ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private long AV30count ;
   private java.math.BigDecimal AV19TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV20TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal AV59Verliqretro2ds_10_tfliqdimprecalcu ;
   private java.math.BigDecimal AV60Verliqretro2ds_11_tfliqdimprecalcu_to ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV42DTipoConCod ;
   private String AV14TFDConCodigo ;
   private String A394DConCodigo ;
   private String AV53Verliqretro2ds_4_dtipoconcod ;
   private String AV55Verliqretro2ds_6_tfdconcodigo ;
   private String scmdbuf ;
   private String lV55Verliqretro2ds_6_tfdconcodigo ;
   private String A464DTipoConCod ;
   private boolean returnInSub ;
   private boolean brk20M2 ;
   private boolean brk20M4 ;
   private String AV39OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV41OptionIndexesJson ;
   private String AV11TFDTipoConCod_SelsJson ;
   private String AV13TFDConCodigo_SelsJson ;
   private String AV16TFDConDescrip_SelsJson ;
   private String AV36DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV17TFDConDescrip ;
   private String AV57Verliqretro2ds_8_tfdcondescrip ;
   private String lV57Verliqretro2ds_8_tfdcondescrip ;
   private String A393DConDescrip ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P020M2_A3CliCod ;
   private short[] P020M2_A1EmpCod ;
   private int[] P020M2_A31LiqNro ;
   private String[] P020M2_A394DConCodigo ;
   private java.math.BigDecimal[] P020M2_A764LiqDImpReCalcu ;
   private String[] P020M2_A393DConDescrip ;
   private String[] P020M2_A464DTipoConCod ;
   private int[] P020M2_A6LegNumero ;
   private int[] P020M2_A81LiqDSecuencial ;
   private int[] P020M3_A3CliCod ;
   private short[] P020M3_A1EmpCod ;
   private int[] P020M3_A31LiqNro ;
   private String[] P020M3_A393DConDescrip ;
   private java.math.BigDecimal[] P020M3_A764LiqDImpReCalcu ;
   private String[] P020M3_A394DConCodigo ;
   private String[] P020M3_A464DTipoConCod ;
   private int[] P020M3_A6LegNumero ;
   private int[] P020M3_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV12TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV15TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV54Verliqretro2ds_5_tfdtipoconcod_sels ;
   private GXSimpleCollection<String> AV56Verliqretro2ds_7_tfdconcodigo_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV28OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private GXSimpleCollection<String> AV18TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV58Verliqretro2ds_9_tfdcondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class verliqretro2getfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P020M2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV54Verliqretro2ds_5_tfdtipoconcod_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV56Verliqretro2ds_7_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV58Verliqretro2ds_9_tfdcondescrip_sels ,
                                          int AV54Verliqretro2ds_5_tfdtipoconcod_sels_size ,
                                          int AV56Verliqretro2ds_7_tfdconcodigo_sels_size ,
                                          String AV55Verliqretro2ds_6_tfdconcodigo ,
                                          int AV58Verliqretro2ds_9_tfdcondescrip_sels_size ,
                                          String AV57Verliqretro2ds_8_tfdcondescrip ,
                                          java.math.BigDecimal AV59Verliqretro2ds_10_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV60Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV50Verliqretro2ds_1_clicod ,
                                          short AV51Verliqretro2ds_2_empcod ,
                                          int AV52Verliqretro2ds_3_liqnro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[7];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqNro, DConCodigo, LiqDImpReCalcu, DConDescrip, DTipoConCod, LegNumero, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      addWhere(sWhereString, "(DTipoConCod <> ( 'CAL_ARG'))");
      if ( AV54Verliqretro2ds_5_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Verliqretro2ds_5_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV56Verliqretro2ds_7_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Verliqretro2ds_6_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int2[3] = (byte)(1) ;
      }
      if ( AV56Verliqretro2ds_7_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Verliqretro2ds_7_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV58Verliqretro2ds_9_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Verliqretro2ds_8_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int2[4] = (byte)(1) ;
      }
      if ( AV58Verliqretro2ds_9_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Verliqretro2ds_9_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Verliqretro2ds_10_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int2[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60Verliqretro2ds_11_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int2[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, DConCodigo" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P020M3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV54Verliqretro2ds_5_tfdtipoconcod_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV56Verliqretro2ds_7_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV58Verliqretro2ds_9_tfdcondescrip_sels ,
                                          int AV54Verliqretro2ds_5_tfdtipoconcod_sels_size ,
                                          int AV56Verliqretro2ds_7_tfdconcodigo_sels_size ,
                                          String AV55Verliqretro2ds_6_tfdconcodigo ,
                                          int AV58Verliqretro2ds_9_tfdcondescrip_sels_size ,
                                          String AV57Verliqretro2ds_8_tfdcondescrip ,
                                          java.math.BigDecimal AV59Verliqretro2ds_10_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV60Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV50Verliqretro2ds_1_clicod ,
                                          short AV51Verliqretro2ds_2_empcod ,
                                          int AV52Verliqretro2ds_3_liqnro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[7];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqNro, DConDescrip, LiqDImpReCalcu, DConCodigo, DTipoConCod, LegNumero, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      addWhere(sWhereString, "(DTipoConCod <> ( 'CAL_ARG'))");
      if ( AV54Verliqretro2ds_5_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Verliqretro2ds_5_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV56Verliqretro2ds_7_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Verliqretro2ds_6_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      if ( AV56Verliqretro2ds_7_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Verliqretro2ds_7_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV58Verliqretro2ds_9_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Verliqretro2ds_8_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int5[4] = (byte)(1) ;
      }
      if ( AV58Verliqretro2ds_9_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Verliqretro2ds_9_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Verliqretro2ds_10_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int5[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60Verliqretro2ds_11_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int5[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, DConDescrip" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P020M2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).intValue() );
            case 1 :
                  return conditional_P020M3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020M2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020M3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               return;
      }
   }

}


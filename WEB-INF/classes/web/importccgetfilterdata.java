package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importccgetfilterdata extends GXProcedure
{
   public importccgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importccgetfilterdata.class ), "" );
   }

   public importccgetfilterdata( int remoteHandle ,
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
      importccgetfilterdata.this.aP5 = new String[] {""};
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
      importccgetfilterdata.this.AV37DDOName = aP0;
      importccgetfilterdata.this.AV35SearchTxt = aP1;
      importccgetfilterdata.this.AV36SearchTxtTo = aP2;
      importccgetfilterdata.this.aP3 = aP3;
      importccgetfilterdata.this.aP4 = aP4;
      importccgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_IMPLIQCONEXTCODYDESCRIP") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQCONEXTCODYDESCRIPOPTIONS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_IMPLIQAFIPCODMASDESC") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQAFIPCODMASDESCOPTIONS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_IMPLIQCONSISCODYDESCRIP") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQCONSISCODYDESCRIPOPTIONS' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV41OptionsJson = AV40Options.toJSonString(false) ;
      AV44OptionsDescJson = AV43OptionsDesc.toJSonString(false) ;
      AV46OptionIndexesJson = AV45OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV48Session.getValue("ImportCCGridState"), "") == 0 )
      {
         AV50GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ImportCCGridState"), null, null);
      }
      else
      {
         AV50GridState.fromxml(AV48Session.getValue("ImportCCGridState"), null, null);
      }
      AV70GXV1 = 1 ;
      while ( AV70GXV1 <= AV50GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV51GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV50GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV70GXV1));
         if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV56TFiconoUpdateOperator = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQTIPOCONCOD_SEL") == 0 )
         {
            AV63TFImpLiqTipoConCod_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV64TFImpLiqTipoConCod_Sels.fromJSonString(AV63TFImpLiqTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONEXTCODYDESCRIP") == 0 )
         {
            AV58TFImpLiqConExtCodYDescrip = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONEXTCODYDESCRIP_SEL") == 0 )
         {
            AV57TFImpLiqConExtCodYDescrip_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFImpLiqConExtCodYDescrip_Sels.fromJSonString(AV57TFImpLiqConExtCodYDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQAFIPCODMASDESC") == 0 )
         {
            AV66TFImpLiqAfipCodMasDesc = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQAFIPCODMASDESC_SEL") == 0 )
         {
            AV65TFImpLiqAfipCodMasDesc_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFImpLiqAfipCodMasDesc_Sels.fromJSonString(AV65TFImpLiqAfipCodMasDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONSISCODYDESCRIP") == 0 )
         {
            AV61TFImpLiqConSisCodYDescrip = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONSISCODYDESCRIP_SEL") == 0 )
         {
            AV60TFImpLiqConSisCodYDescrip_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV62TFImpLiqConSisCodYDescrip_Sels.fromJSonString(AV60TFImpLiqConSisCodYDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV53CliCod = (int)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV54EmpCod = (short)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV70GXV1 = (int)(AV70GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADIMPLIQCONEXTCODYDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV58TFImpLiqConExtCodYDescrip = AV35SearchTxt ;
      AV59TFImpLiqConExtCodYDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV72Importccds_1_tficonoupdate = AV55TFiconoUpdate ;
      AV73Importccds_2_tficonoupdateoperator = AV56TFiconoUpdateOperator ;
      AV74Importccds_3_tfimpliqtipoconcod_sels = AV64TFImpLiqTipoConCod_Sels ;
      AV75Importccds_4_tfimpliqconextcodydescrip = AV58TFImpLiqConExtCodYDescrip ;
      AV76Importccds_5_tfimpliqconextcodydescrip_sels = AV59TFImpLiqConExtCodYDescrip_Sels ;
      AV77Importccds_6_tfimpliqafipcodmasdesc = AV66TFImpLiqAfipCodMasDesc ;
      AV78Importccds_7_tfimpliqafipcodmasdesc_sels = AV67TFImpLiqAfipCodMasDesc_Sels ;
      AV79Importccds_8_tfimpliqconsiscodydescrip = AV61TFImpLiqConSisCodYDescrip ;
      AV80Importccds_9_tfimpliqconsiscodydescrip_sels = AV62TFImpLiqConSisCodYDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A911ImpLiqTipoConCod ,
                                           AV74Importccds_3_tfimpliqtipoconcod_sels ,
                                           A701ImpLiqConExtCodYDescrip ,
                                           AV76Importccds_5_tfimpliqconextcodydescrip_sels ,
                                           A912ImpLiqAfipCodMasDesc ,
                                           AV78Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                           A702ImpLiqConSisCodYDescrip ,
                                           AV80Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                           Short.valueOf(AV73Importccds_2_tficonoupdateoperator) ,
                                           Integer.valueOf(AV74Importccds_3_tfimpliqtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV76Importccds_5_tfimpliqconextcodydescrip_sels.size()) ,
                                           AV75Importccds_4_tfimpliqconextcodydescrip ,
                                           Integer.valueOf(AV78Importccds_7_tfimpliqafipcodmasdesc_sels.size()) ,
                                           AV77Importccds_6_tfimpliqafipcodmasdesc ,
                                           Integer.valueOf(AV80Importccds_9_tfimpliqconsiscodydescrip_sels.size()) ,
                                           AV79Importccds_8_tfimpliqconsiscodydescrip ,
                                           A659ImpLiqConError ,
                                           A660ImpLiqConWarning ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV53CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV54EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV75Importccds_4_tfimpliqconextcodydescrip = GXutil.concat( GXutil.rtrim( AV75Importccds_4_tfimpliqconextcodydescrip), "%", "") ;
      lV77Importccds_6_tfimpliqafipcodmasdesc = GXutil.concat( GXutil.rtrim( AV77Importccds_6_tfimpliqafipcodmasdesc), "%", "") ;
      lV79Importccds_8_tfimpliqconsiscodydescrip = GXutil.concat( GXutil.rtrim( AV79Importccds_8_tfimpliqconsiscodydescrip), "%", "") ;
      /* Using cursor P00NW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV53CliCod), Short.valueOf(AV54EmpCod), lV75Importccds_4_tfimpliqconextcodydescrip, lV77Importccds_6_tfimpliqafipcodmasdesc, lV79Importccds_8_tfimpliqconsiscodydescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkNW2 = false ;
         A3CliCod = P00NW2_A3CliCod[0] ;
         A1EmpCod = P00NW2_A1EmpCod[0] ;
         A701ImpLiqConExtCodYDescrip = P00NW2_A701ImpLiqConExtCodYDescrip[0] ;
         A660ImpLiqConWarning = P00NW2_A660ImpLiqConWarning[0] ;
         A659ImpLiqConError = P00NW2_A659ImpLiqConError[0] ;
         A702ImpLiqConSisCodYDescrip = P00NW2_A702ImpLiqConSisCodYDescrip[0] ;
         A912ImpLiqAfipCodMasDesc = P00NW2_A912ImpLiqAfipCodMasDesc[0] ;
         A911ImpLiqTipoConCod = P00NW2_A911ImpLiqTipoConCod[0] ;
         A88ImpLiqSec = P00NW2_A88ImpLiqSec[0] ;
         A89ImpLiqConExtCod = P00NW2_A89ImpLiqConExtCod[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00NW2_A701ImpLiqConExtCodYDescrip[0], A701ImpLiqConExtCodYDescrip) == 0 ) )
         {
            brkNW2 = false ;
            A3CliCod = P00NW2_A3CliCod[0] ;
            A1EmpCod = P00NW2_A1EmpCod[0] ;
            A88ImpLiqSec = P00NW2_A88ImpLiqSec[0] ;
            A89ImpLiqConExtCod = P00NW2_A89ImpLiqConExtCod[0] ;
            AV47count = (long)(AV47count+1) ;
            brkNW2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A701ImpLiqConExtCodYDescrip)==0) )
         {
            AV39Option = A701ImpLiqConExtCodYDescrip ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkNW2 )
         {
            brkNW2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADIMPLIQAFIPCODMASDESCOPTIONS' Routine */
      returnInSub = false ;
      AV66TFImpLiqAfipCodMasDesc = AV35SearchTxt ;
      AV67TFImpLiqAfipCodMasDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV72Importccds_1_tficonoupdate = AV55TFiconoUpdate ;
      AV73Importccds_2_tficonoupdateoperator = AV56TFiconoUpdateOperator ;
      AV74Importccds_3_tfimpliqtipoconcod_sels = AV64TFImpLiqTipoConCod_Sels ;
      AV75Importccds_4_tfimpliqconextcodydescrip = AV58TFImpLiqConExtCodYDescrip ;
      AV76Importccds_5_tfimpliqconextcodydescrip_sels = AV59TFImpLiqConExtCodYDescrip_Sels ;
      AV77Importccds_6_tfimpliqafipcodmasdesc = AV66TFImpLiqAfipCodMasDesc ;
      AV78Importccds_7_tfimpliqafipcodmasdesc_sels = AV67TFImpLiqAfipCodMasDesc_Sels ;
      AV79Importccds_8_tfimpliqconsiscodydescrip = AV61TFImpLiqConSisCodYDescrip ;
      AV80Importccds_9_tfimpliqconsiscodydescrip_sels = AV62TFImpLiqConSisCodYDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A911ImpLiqTipoConCod ,
                                           AV74Importccds_3_tfimpliqtipoconcod_sels ,
                                           A701ImpLiqConExtCodYDescrip ,
                                           AV76Importccds_5_tfimpliqconextcodydescrip_sels ,
                                           A912ImpLiqAfipCodMasDesc ,
                                           AV78Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                           A702ImpLiqConSisCodYDescrip ,
                                           AV80Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                           Short.valueOf(AV73Importccds_2_tficonoupdateoperator) ,
                                           Integer.valueOf(AV74Importccds_3_tfimpliqtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV76Importccds_5_tfimpliqconextcodydescrip_sels.size()) ,
                                           AV75Importccds_4_tfimpliqconextcodydescrip ,
                                           Integer.valueOf(AV78Importccds_7_tfimpliqafipcodmasdesc_sels.size()) ,
                                           AV77Importccds_6_tfimpliqafipcodmasdesc ,
                                           Integer.valueOf(AV80Importccds_9_tfimpliqconsiscodydescrip_sels.size()) ,
                                           AV79Importccds_8_tfimpliqconsiscodydescrip ,
                                           A659ImpLiqConError ,
                                           A660ImpLiqConWarning ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV53CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV54EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV75Importccds_4_tfimpliqconextcodydescrip = GXutil.concat( GXutil.rtrim( AV75Importccds_4_tfimpliqconextcodydescrip), "%", "") ;
      lV77Importccds_6_tfimpliqafipcodmasdesc = GXutil.concat( GXutil.rtrim( AV77Importccds_6_tfimpliqafipcodmasdesc), "%", "") ;
      lV79Importccds_8_tfimpliqconsiscodydescrip = GXutil.concat( GXutil.rtrim( AV79Importccds_8_tfimpliqconsiscodydescrip), "%", "") ;
      /* Using cursor P00NW3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV53CliCod), Short.valueOf(AV54EmpCod), lV75Importccds_4_tfimpliqconextcodydescrip, lV77Importccds_6_tfimpliqafipcodmasdesc, lV79Importccds_8_tfimpliqconsiscodydescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkNW4 = false ;
         A3CliCod = P00NW3_A3CliCod[0] ;
         A1EmpCod = P00NW3_A1EmpCod[0] ;
         A912ImpLiqAfipCodMasDesc = P00NW3_A912ImpLiqAfipCodMasDesc[0] ;
         A660ImpLiqConWarning = P00NW3_A660ImpLiqConWarning[0] ;
         A659ImpLiqConError = P00NW3_A659ImpLiqConError[0] ;
         A702ImpLiqConSisCodYDescrip = P00NW3_A702ImpLiqConSisCodYDescrip[0] ;
         A701ImpLiqConExtCodYDescrip = P00NW3_A701ImpLiqConExtCodYDescrip[0] ;
         A911ImpLiqTipoConCod = P00NW3_A911ImpLiqTipoConCod[0] ;
         A88ImpLiqSec = P00NW3_A88ImpLiqSec[0] ;
         A89ImpLiqConExtCod = P00NW3_A89ImpLiqConExtCod[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00NW3_A912ImpLiqAfipCodMasDesc[0], A912ImpLiqAfipCodMasDesc) == 0 ) )
         {
            brkNW4 = false ;
            A3CliCod = P00NW3_A3CliCod[0] ;
            A1EmpCod = P00NW3_A1EmpCod[0] ;
            A88ImpLiqSec = P00NW3_A88ImpLiqSec[0] ;
            A89ImpLiqConExtCod = P00NW3_A89ImpLiqConExtCod[0] ;
            AV47count = (long)(AV47count+1) ;
            brkNW4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A912ImpLiqAfipCodMasDesc)==0) )
         {
            AV39Option = A912ImpLiqAfipCodMasDesc ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkNW4 )
         {
            brkNW4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADIMPLIQCONSISCODYDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV61TFImpLiqConSisCodYDescrip = AV35SearchTxt ;
      AV62TFImpLiqConSisCodYDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV72Importccds_1_tficonoupdate = AV55TFiconoUpdate ;
      AV73Importccds_2_tficonoupdateoperator = AV56TFiconoUpdateOperator ;
      AV74Importccds_3_tfimpliqtipoconcod_sels = AV64TFImpLiqTipoConCod_Sels ;
      AV75Importccds_4_tfimpliqconextcodydescrip = AV58TFImpLiqConExtCodYDescrip ;
      AV76Importccds_5_tfimpliqconextcodydescrip_sels = AV59TFImpLiqConExtCodYDescrip_Sels ;
      AV77Importccds_6_tfimpliqafipcodmasdesc = AV66TFImpLiqAfipCodMasDesc ;
      AV78Importccds_7_tfimpliqafipcodmasdesc_sels = AV67TFImpLiqAfipCodMasDesc_Sels ;
      AV79Importccds_8_tfimpliqconsiscodydescrip = AV61TFImpLiqConSisCodYDescrip ;
      AV80Importccds_9_tfimpliqconsiscodydescrip_sels = AV62TFImpLiqConSisCodYDescrip_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A911ImpLiqTipoConCod ,
                                           AV74Importccds_3_tfimpliqtipoconcod_sels ,
                                           A701ImpLiqConExtCodYDescrip ,
                                           AV76Importccds_5_tfimpliqconextcodydescrip_sels ,
                                           A912ImpLiqAfipCodMasDesc ,
                                           AV78Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                           A702ImpLiqConSisCodYDescrip ,
                                           AV80Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                           Short.valueOf(AV73Importccds_2_tficonoupdateoperator) ,
                                           Integer.valueOf(AV74Importccds_3_tfimpliqtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV76Importccds_5_tfimpliqconextcodydescrip_sels.size()) ,
                                           AV75Importccds_4_tfimpliqconextcodydescrip ,
                                           Integer.valueOf(AV78Importccds_7_tfimpliqafipcodmasdesc_sels.size()) ,
                                           AV77Importccds_6_tfimpliqafipcodmasdesc ,
                                           Integer.valueOf(AV80Importccds_9_tfimpliqconsiscodydescrip_sels.size()) ,
                                           AV79Importccds_8_tfimpliqconsiscodydescrip ,
                                           A659ImpLiqConError ,
                                           A660ImpLiqConWarning ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV53CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV54EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV75Importccds_4_tfimpliqconextcodydescrip = GXutil.concat( GXutil.rtrim( AV75Importccds_4_tfimpliqconextcodydescrip), "%", "") ;
      lV77Importccds_6_tfimpliqafipcodmasdesc = GXutil.concat( GXutil.rtrim( AV77Importccds_6_tfimpliqafipcodmasdesc), "%", "") ;
      lV79Importccds_8_tfimpliqconsiscodydescrip = GXutil.concat( GXutil.rtrim( AV79Importccds_8_tfimpliqconsiscodydescrip), "%", "") ;
      /* Using cursor P00NW4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV53CliCod), Short.valueOf(AV54EmpCod), lV75Importccds_4_tfimpliqconextcodydescrip, lV77Importccds_6_tfimpliqafipcodmasdesc, lV79Importccds_8_tfimpliqconsiscodydescrip});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brkNW6 = false ;
         A3CliCod = P00NW4_A3CliCod[0] ;
         A1EmpCod = P00NW4_A1EmpCod[0] ;
         A702ImpLiqConSisCodYDescrip = P00NW4_A702ImpLiqConSisCodYDescrip[0] ;
         A660ImpLiqConWarning = P00NW4_A660ImpLiqConWarning[0] ;
         A659ImpLiqConError = P00NW4_A659ImpLiqConError[0] ;
         A912ImpLiqAfipCodMasDesc = P00NW4_A912ImpLiqAfipCodMasDesc[0] ;
         A701ImpLiqConExtCodYDescrip = P00NW4_A701ImpLiqConExtCodYDescrip[0] ;
         A911ImpLiqTipoConCod = P00NW4_A911ImpLiqTipoConCod[0] ;
         A88ImpLiqSec = P00NW4_A88ImpLiqSec[0] ;
         A89ImpLiqConExtCod = P00NW4_A89ImpLiqConExtCod[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00NW4_A702ImpLiqConSisCodYDescrip[0], A702ImpLiqConSisCodYDescrip) == 0 ) )
         {
            brkNW6 = false ;
            A3CliCod = P00NW4_A3CliCod[0] ;
            A1EmpCod = P00NW4_A1EmpCod[0] ;
            A88ImpLiqSec = P00NW4_A88ImpLiqSec[0] ;
            A89ImpLiqConExtCod = P00NW4_A89ImpLiqConExtCod[0] ;
            AV47count = (long)(AV47count+1) ;
            brkNW6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A702ImpLiqConSisCodYDescrip)==0) )
         {
            AV39Option = A702ImpLiqConSisCodYDescrip ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkNW6 )
         {
            brkNW6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = importccgetfilterdata.this.AV41OptionsJson;
      this.aP4[0] = importccgetfilterdata.this.AV44OptionsDescJson;
      this.aP5[0] = importccgetfilterdata.this.AV46OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV41OptionsJson = "" ;
      AV44OptionsDescJson = "" ;
      AV46OptionIndexesJson = "" ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV48Session = httpContext.getWebSession();
      AV50GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV51GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV63TFImpLiqTipoConCod_SelsJson = "" ;
      AV64TFImpLiqTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFImpLiqConExtCodYDescrip = "" ;
      AV57TFImpLiqConExtCodYDescrip_SelsJson = "" ;
      AV59TFImpLiqConExtCodYDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66TFImpLiqAfipCodMasDesc = "" ;
      AV65TFImpLiqAfipCodMasDesc_SelsJson = "" ;
      AV67TFImpLiqAfipCodMasDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61TFImpLiqConSisCodYDescrip = "" ;
      AV60TFImpLiqConSisCodYDescrip_SelsJson = "" ;
      AV62TFImpLiqConSisCodYDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A701ImpLiqConExtCodYDescrip = "" ;
      AV72Importccds_1_tficonoupdate = "" ;
      AV55TFiconoUpdate = "" ;
      AV74Importccds_3_tfimpliqtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Importccds_4_tfimpliqconextcodydescrip = "" ;
      AV76Importccds_5_tfimpliqconextcodydescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Importccds_6_tfimpliqafipcodmasdesc = "" ;
      AV78Importccds_7_tfimpliqafipcodmasdesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Importccds_8_tfimpliqconsiscodydescrip = "" ;
      AV80Importccds_9_tfimpliqconsiscodydescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV75Importccds_4_tfimpliqconextcodydescrip = "" ;
      lV77Importccds_6_tfimpliqafipcodmasdesc = "" ;
      lV79Importccds_8_tfimpliqconsiscodydescrip = "" ;
      A911ImpLiqTipoConCod = "" ;
      A912ImpLiqAfipCodMasDesc = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A659ImpLiqConError = "" ;
      A660ImpLiqConWarning = "" ;
      P00NW2_A3CliCod = new int[1] ;
      P00NW2_A1EmpCod = new short[1] ;
      P00NW2_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      P00NW2_A660ImpLiqConWarning = new String[] {""} ;
      P00NW2_A659ImpLiqConError = new String[] {""} ;
      P00NW2_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      P00NW2_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      P00NW2_A911ImpLiqTipoConCod = new String[] {""} ;
      P00NW2_A88ImpLiqSec = new short[1] ;
      P00NW2_A89ImpLiqConExtCod = new String[] {""} ;
      A89ImpLiqConExtCod = "" ;
      AV39Option = "" ;
      P00NW3_A3CliCod = new int[1] ;
      P00NW3_A1EmpCod = new short[1] ;
      P00NW3_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      P00NW3_A660ImpLiqConWarning = new String[] {""} ;
      P00NW3_A659ImpLiqConError = new String[] {""} ;
      P00NW3_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      P00NW3_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      P00NW3_A911ImpLiqTipoConCod = new String[] {""} ;
      P00NW3_A88ImpLiqSec = new short[1] ;
      P00NW3_A89ImpLiqConExtCod = new String[] {""} ;
      P00NW4_A3CliCod = new int[1] ;
      P00NW4_A1EmpCod = new short[1] ;
      P00NW4_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      P00NW4_A660ImpLiqConWarning = new String[] {""} ;
      P00NW4_A659ImpLiqConError = new String[] {""} ;
      P00NW4_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      P00NW4_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      P00NW4_A911ImpLiqTipoConCod = new String[] {""} ;
      P00NW4_A88ImpLiqSec = new short[1] ;
      P00NW4_A89ImpLiqConExtCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importccgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00NW2_A3CliCod, P00NW2_A1EmpCod, P00NW2_A701ImpLiqConExtCodYDescrip, P00NW2_A660ImpLiqConWarning, P00NW2_A659ImpLiqConError, P00NW2_A702ImpLiqConSisCodYDescrip, P00NW2_A912ImpLiqAfipCodMasDesc, P00NW2_A911ImpLiqTipoConCod, P00NW2_A88ImpLiqSec, P00NW2_A89ImpLiqConExtCod
            }
            , new Object[] {
            P00NW3_A3CliCod, P00NW3_A1EmpCod, P00NW3_A912ImpLiqAfipCodMasDesc, P00NW3_A660ImpLiqConWarning, P00NW3_A659ImpLiqConError, P00NW3_A702ImpLiqConSisCodYDescrip, P00NW3_A701ImpLiqConExtCodYDescrip, P00NW3_A911ImpLiqTipoConCod, P00NW3_A88ImpLiqSec, P00NW3_A89ImpLiqConExtCod
            }
            , new Object[] {
            P00NW4_A3CliCod, P00NW4_A1EmpCod, P00NW4_A702ImpLiqConSisCodYDescrip, P00NW4_A660ImpLiqConWarning, P00NW4_A659ImpLiqConError, P00NW4_A912ImpLiqAfipCodMasDesc, P00NW4_A701ImpLiqConExtCodYDescrip, P00NW4_A911ImpLiqTipoConCod, P00NW4_A88ImpLiqSec, P00NW4_A89ImpLiqConExtCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV56TFiconoUpdateOperator ;
   private short AV54EmpCod ;
   private short AV73Importccds_2_tficonoupdateoperator ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short Gx_err ;
   private int AV70GXV1 ;
   private int AV53CliCod ;
   private int AV74Importccds_3_tfimpliqtipoconcod_sels_size ;
   private int AV76Importccds_5_tfimpliqconextcodydescrip_sels_size ;
   private int AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size ;
   private int AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size ;
   private int A3CliCod ;
   private long AV47count ;
   private String AV72Importccds_1_tficonoupdate ;
   private String AV55TFiconoUpdate ;
   private String scmdbuf ;
   private String A911ImpLiqTipoConCod ;
   private String A89ImpLiqConExtCod ;
   private boolean returnInSub ;
   private boolean brkNW2 ;
   private boolean brkNW4 ;
   private boolean brkNW6 ;
   private String AV41OptionsJson ;
   private String AV44OptionsDescJson ;
   private String AV46OptionIndexesJson ;
   private String AV63TFImpLiqTipoConCod_SelsJson ;
   private String AV57TFImpLiqConExtCodYDescrip_SelsJson ;
   private String AV65TFImpLiqAfipCodMasDesc_SelsJson ;
   private String AV60TFImpLiqConSisCodYDescrip_SelsJson ;
   private String AV37DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV58TFImpLiqConExtCodYDescrip ;
   private String AV66TFImpLiqAfipCodMasDesc ;
   private String AV61TFImpLiqConSisCodYDescrip ;
   private String A701ImpLiqConExtCodYDescrip ;
   private String AV75Importccds_4_tfimpliqconextcodydescrip ;
   private String AV77Importccds_6_tfimpliqafipcodmasdesc ;
   private String AV79Importccds_8_tfimpliqconsiscodydescrip ;
   private String lV75Importccds_4_tfimpliqconextcodydescrip ;
   private String lV77Importccds_6_tfimpliqafipcodmasdesc ;
   private String lV79Importccds_8_tfimpliqconsiscodydescrip ;
   private String A912ImpLiqAfipCodMasDesc ;
   private String A702ImpLiqConSisCodYDescrip ;
   private String A659ImpLiqConError ;
   private String A660ImpLiqConWarning ;
   private String AV39Option ;
   private com.genexus.webpanels.WebSession AV48Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00NW2_A3CliCod ;
   private short[] P00NW2_A1EmpCod ;
   private String[] P00NW2_A701ImpLiqConExtCodYDescrip ;
   private String[] P00NW2_A660ImpLiqConWarning ;
   private String[] P00NW2_A659ImpLiqConError ;
   private String[] P00NW2_A702ImpLiqConSisCodYDescrip ;
   private String[] P00NW2_A912ImpLiqAfipCodMasDesc ;
   private String[] P00NW2_A911ImpLiqTipoConCod ;
   private short[] P00NW2_A88ImpLiqSec ;
   private String[] P00NW2_A89ImpLiqConExtCod ;
   private int[] P00NW3_A3CliCod ;
   private short[] P00NW3_A1EmpCod ;
   private String[] P00NW3_A912ImpLiqAfipCodMasDesc ;
   private String[] P00NW3_A660ImpLiqConWarning ;
   private String[] P00NW3_A659ImpLiqConError ;
   private String[] P00NW3_A702ImpLiqConSisCodYDescrip ;
   private String[] P00NW3_A701ImpLiqConExtCodYDescrip ;
   private String[] P00NW3_A911ImpLiqTipoConCod ;
   private short[] P00NW3_A88ImpLiqSec ;
   private String[] P00NW3_A89ImpLiqConExtCod ;
   private int[] P00NW4_A3CliCod ;
   private short[] P00NW4_A1EmpCod ;
   private String[] P00NW4_A702ImpLiqConSisCodYDescrip ;
   private String[] P00NW4_A660ImpLiqConWarning ;
   private String[] P00NW4_A659ImpLiqConError ;
   private String[] P00NW4_A912ImpLiqAfipCodMasDesc ;
   private String[] P00NW4_A701ImpLiqConExtCodYDescrip ;
   private String[] P00NW4_A911ImpLiqTipoConCod ;
   private short[] P00NW4_A88ImpLiqSec ;
   private String[] P00NW4_A89ImpLiqConExtCod ;
   private GXSimpleCollection<String> AV64TFImpLiqTipoConCod_Sels ;
   private GXSimpleCollection<String> AV74Importccds_3_tfimpliqtipoconcod_sels ;
   private GXSimpleCollection<String> AV40Options ;
   private GXSimpleCollection<String> AV43OptionsDesc ;
   private GXSimpleCollection<String> AV45OptionIndexes ;
   private GXSimpleCollection<String> AV59TFImpLiqConExtCodYDescrip_Sels ;
   private GXSimpleCollection<String> AV67TFImpLiqAfipCodMasDesc_Sels ;
   private GXSimpleCollection<String> AV62TFImpLiqConSisCodYDescrip_Sels ;
   private GXSimpleCollection<String> AV76Importccds_5_tfimpliqconextcodydescrip_sels ;
   private GXSimpleCollection<String> AV78Importccds_7_tfimpliqafipcodmasdesc_sels ;
   private GXSimpleCollection<String> AV80Importccds_9_tfimpliqconsiscodydescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV50GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV51GridStateFilterValue ;
}

final  class importccgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00NW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A911ImpLiqTipoConCod ,
                                          GXSimpleCollection<String> AV74Importccds_3_tfimpliqtipoconcod_sels ,
                                          String A701ImpLiqConExtCodYDescrip ,
                                          GXSimpleCollection<String> AV76Importccds_5_tfimpliqconextcodydescrip_sels ,
                                          String A912ImpLiqAfipCodMasDesc ,
                                          GXSimpleCollection<String> AV78Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                          String A702ImpLiqConSisCodYDescrip ,
                                          GXSimpleCollection<String> AV80Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                          short AV73Importccds_2_tficonoupdateoperator ,
                                          int AV74Importccds_3_tfimpliqtipoconcod_sels_size ,
                                          int AV76Importccds_5_tfimpliqconextcodydescrip_sels_size ,
                                          String AV75Importccds_4_tfimpliqconextcodydescrip ,
                                          int AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size ,
                                          String AV77Importccds_6_tfimpliqafipcodmasdesc ,
                                          int AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size ,
                                          String AV79Importccds_8_tfimpliqconsiscodydescrip ,
                                          String A659ImpLiqConError ,
                                          String A660ImpLiqConWarning ,
                                          int A3CliCod ,
                                          int AV53CliCod ,
                                          short A1EmpCod ,
                                          short AV54EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[5];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqConExtCodYDescrip, ImpLiqConWarning, ImpLiqConError, ImpLiqConSisCodYDescrip, ImpLiqAfipCodMasDesc, ImpLiqTipoConCod, ImpLiqSec, ImpLiqConExtCod" ;
      scmdbuf += " FROM importacion_conceptos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV73Importccds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and Not (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV73Importccds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqConError))=0))");
      }
      if ( AV73Importccds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV74Importccds_3_tfimpliqtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Importccds_3_tfimpliqtipoconcod_sels, "ImpLiqTipoConCod IN (", ")")+")");
      }
      if ( ( AV76Importccds_5_tfimpliqconextcodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Importccds_4_tfimpliqconextcodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConExtCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int2[2] = (byte)(1) ;
      }
      if ( AV76Importccds_5_tfimpliqconextcodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Importccds_5_tfimpliqconextcodydescrip_sels, "ImpLiqConExtCodYDescrip IN (", ")")+")");
      }
      if ( ( AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Importccds_6_tfimpliqafipcodmasdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqAfipCodMasDesc) like LOWER(?))");
      }
      else
      {
         GXv_int2[3] = (byte)(1) ;
      }
      if ( AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Importccds_7_tfimpliqafipcodmasdesc_sels, "ImpLiqAfipCodMasDesc IN (", ")")+")");
      }
      if ( ( AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Importccds_8_tfimpliqconsiscodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConSisCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int2[4] = (byte)(1) ;
      }
      if ( AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Importccds_9_tfimpliqconsiscodydescrip_sels, "ImpLiqConSisCodYDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqConExtCodYDescrip" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P00NW3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A911ImpLiqTipoConCod ,
                                          GXSimpleCollection<String> AV74Importccds_3_tfimpliqtipoconcod_sels ,
                                          String A701ImpLiqConExtCodYDescrip ,
                                          GXSimpleCollection<String> AV76Importccds_5_tfimpliqconextcodydescrip_sels ,
                                          String A912ImpLiqAfipCodMasDesc ,
                                          GXSimpleCollection<String> AV78Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                          String A702ImpLiqConSisCodYDescrip ,
                                          GXSimpleCollection<String> AV80Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                          short AV73Importccds_2_tficonoupdateoperator ,
                                          int AV74Importccds_3_tfimpliqtipoconcod_sels_size ,
                                          int AV76Importccds_5_tfimpliqconextcodydescrip_sels_size ,
                                          String AV75Importccds_4_tfimpliqconextcodydescrip ,
                                          int AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size ,
                                          String AV77Importccds_6_tfimpliqafipcodmasdesc ,
                                          int AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size ,
                                          String AV79Importccds_8_tfimpliqconsiscodydescrip ,
                                          String A659ImpLiqConError ,
                                          String A660ImpLiqConWarning ,
                                          int A3CliCod ,
                                          int AV53CliCod ,
                                          short A1EmpCod ,
                                          short AV54EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[5];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqAfipCodMasDesc, ImpLiqConWarning, ImpLiqConError, ImpLiqConSisCodYDescrip, ImpLiqConExtCodYDescrip, ImpLiqTipoConCod, ImpLiqSec, ImpLiqConExtCod" ;
      scmdbuf += " FROM importacion_conceptos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV73Importccds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and Not (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV73Importccds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqConError))=0))");
      }
      if ( AV73Importccds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV74Importccds_3_tfimpliqtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Importccds_3_tfimpliqtipoconcod_sels, "ImpLiqTipoConCod IN (", ")")+")");
      }
      if ( ( AV76Importccds_5_tfimpliqconextcodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Importccds_4_tfimpliqconextcodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConExtCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int5[2] = (byte)(1) ;
      }
      if ( AV76Importccds_5_tfimpliqconextcodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Importccds_5_tfimpliqconextcodydescrip_sels, "ImpLiqConExtCodYDescrip IN (", ")")+")");
      }
      if ( ( AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Importccds_6_tfimpliqafipcodmasdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqAfipCodMasDesc) like LOWER(?))");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      if ( AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Importccds_7_tfimpliqafipcodmasdesc_sels, "ImpLiqAfipCodMasDesc IN (", ")")+")");
      }
      if ( ( AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Importccds_8_tfimpliqconsiscodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConSisCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int5[4] = (byte)(1) ;
      }
      if ( AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Importccds_9_tfimpliqconsiscodydescrip_sels, "ImpLiqConSisCodYDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqAfipCodMasDesc" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   protected Object[] conditional_P00NW4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A911ImpLiqTipoConCod ,
                                          GXSimpleCollection<String> AV74Importccds_3_tfimpliqtipoconcod_sels ,
                                          String A701ImpLiqConExtCodYDescrip ,
                                          GXSimpleCollection<String> AV76Importccds_5_tfimpliqconextcodydescrip_sels ,
                                          String A912ImpLiqAfipCodMasDesc ,
                                          GXSimpleCollection<String> AV78Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                          String A702ImpLiqConSisCodYDescrip ,
                                          GXSimpleCollection<String> AV80Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                          short AV73Importccds_2_tficonoupdateoperator ,
                                          int AV74Importccds_3_tfimpliqtipoconcod_sels_size ,
                                          int AV76Importccds_5_tfimpliqconextcodydescrip_sels_size ,
                                          String AV75Importccds_4_tfimpliqconextcodydescrip ,
                                          int AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size ,
                                          String AV77Importccds_6_tfimpliqafipcodmasdesc ,
                                          int AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size ,
                                          String AV79Importccds_8_tfimpliqconsiscodydescrip ,
                                          String A659ImpLiqConError ,
                                          String A660ImpLiqConWarning ,
                                          int A3CliCod ,
                                          int AV53CliCod ,
                                          short A1EmpCod ,
                                          short AV54EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqConSisCodYDescrip, ImpLiqConWarning, ImpLiqConError, ImpLiqAfipCodMasDesc, ImpLiqConExtCodYDescrip, ImpLiqTipoConCod, ImpLiqSec, ImpLiqConExtCod" ;
      scmdbuf += " FROM importacion_conceptos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV73Importccds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and Not (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV73Importccds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqConError))=0))");
      }
      if ( AV73Importccds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV74Importccds_3_tfimpliqtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Importccds_3_tfimpliqtipoconcod_sels, "ImpLiqTipoConCod IN (", ")")+")");
      }
      if ( ( AV76Importccds_5_tfimpliqconextcodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Importccds_4_tfimpliqconextcodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConExtCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV76Importccds_5_tfimpliqconextcodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Importccds_5_tfimpliqconextcodydescrip_sels, "ImpLiqConExtCodYDescrip IN (", ")")+")");
      }
      if ( ( AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Importccds_6_tfimpliqafipcodmasdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqAfipCodMasDesc) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV78Importccds_7_tfimpliqafipcodmasdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Importccds_7_tfimpliqafipcodmasdesc_sels, "ImpLiqAfipCodMasDesc IN (", ")")+")");
      }
      if ( ( AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Importccds_8_tfimpliqconsiscodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConSisCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV80Importccds_9_tfimpliqconsiscodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Importccds_9_tfimpliqconsiscodydescrip_sels, "ImpLiqConSisCodYDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqConSisCodYDescrip" ;
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
                  return conditional_P00NW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() );
            case 1 :
                  return conditional_P00NW3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() );
            case 2 :
                  return conditional_P00NW4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00NW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NW3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NW4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((short[]) buf[8])[0] = rslt.getShort(9);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
      }
   }

}


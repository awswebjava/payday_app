package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajofamiliagetfilterdata extends GXProcedure
{
   public importarlegajofamiliagetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajofamiliagetfilterdata.class ), "" );
   }

   public importarlegajofamiliagetfilterdata( int remoteHandle ,
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
      importarlegajofamiliagetfilterdata.this.aP5 = new String[] {""};
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
      importarlegajofamiliagetfilterdata.this.AV34DDOName = aP0;
      importarlegajofamiliagetfilterdata.this.AV35SearchTxt = aP1;
      importarlegajofamiliagetfilterdata.this.AV36SearchTxtTo = aP2;
      importarlegajofamiliagetfilterdata.this.aP3 = aP3;
      importarlegajofamiliagetfilterdata.this.aP4 = aP4;
      importarlegajofamiliagetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_MIGRLEGFAMPAREN") == 0 )
      {
         /* Execute user subroutine: 'LOADMIGRLEGFAMPARENOPTIONS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_MIGRLEGFAMNRODOC") == 0 )
      {
         /* Execute user subroutine: 'LOADMIGRLEGFAMNRODOCOPTIONS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_MIGRLEGFAMADH") == 0 )
      {
         /* Execute user subroutine: 'LOADMIGRLEGFAMADHOPTIONS' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
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
      if ( GXutil.strcmp(AV29Session.getValue("ImportarLegajoFamiliaGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ImportarLegajoFamiliaGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("ImportarLegajoFamiliaGridState"), null, null);
      }
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV55GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV44TFiconoUpdateOperator = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMPAREN") == 0 )
         {
            AV12TFMigrLegFamParen = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMPAREN_SEL") == 0 )
         {
            AV11TFMigrLegFamParen_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFMigrLegFamParen_Sels.fromJSonString(AV11TFMigrLegFamParen_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMNRODOC") == 0 )
         {
            AV15TFMigrLegFamNroDoc = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMNRODOC_SEL") == 0 )
         {
            AV14TFMigrLegFamNroDoc_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFMigrLegFamNroDoc_Sels.fromJSonString(AV14TFMigrLegFamNroDoc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMDEDGAN") == 0 )
         {
            AV17TFMigrLegFamDedGan = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV18TFMigrLegFamDedGan_To = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMADH") == 0 )
         {
            AV20TFMigrLegFamAdh = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMADH_SEL") == 0 )
         {
            AV19TFMigrLegFamAdh_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV21TFMigrLegFamAdh_Sels.fromJSonString(AV19TFMigrLegFamAdh_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV40CliCod = (int)(GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV41EmpCod = (short)(GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MIGRLEGNUMERO") == 0 )
         {
            AV42MigrLegNumero = (int)(GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADMIGRLEGFAMPARENOPTIONS' Routine */
      returnInSub = false ;
      AV12TFMigrLegFamParen = AV35SearchTxt ;
      AV13TFMigrLegFamParen_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Importarlegajofamiliads_1_clicod = AV40CliCod ;
      AV58Importarlegajofamiliads_2_empcod = AV41EmpCod ;
      AV59Importarlegajofamiliads_3_migrlegnumero = AV42MigrLegNumero ;
      AV60Importarlegajofamiliads_4_tficonoupdate = AV43TFiconoUpdate ;
      AV61Importarlegajofamiliads_5_tficonoupdateoperator = AV44TFiconoUpdateOperator ;
      AV62Importarlegajofamiliads_6_tfmigrlegfamparen = AV12TFMigrLegFamParen ;
      AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV13TFMigrLegFamParen_Sels ;
      AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV15TFMigrLegFamNroDoc ;
      AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV16TFMigrLegFamNroDoc_Sels ;
      AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV17TFMigrLegFamDedGan ;
      AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV18TFMigrLegFamDedGan_To ;
      AV68Importarlegajofamiliads_12_tfmigrlegfamadh = AV20TFMigrLegFamAdh ;
      AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV21TFMigrLegFamAdh_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2079MigrLegFamParen ,
                                           AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                           A2080MigrLegFamNroDoc ,
                                           AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                           A2082MigrLegFamAdh ,
                                           AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                           Short.valueOf(AV61Importarlegajofamiliads_5_tficonoupdateoperator) ,
                                           Integer.valueOf(AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels.size()) ,
                                           AV62Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                           Integer.valueOf(AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels.size()) ,
                                           AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                           AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                           AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                           Integer.valueOf(AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels.size()) ,
                                           AV68Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                           A2084MigrLegFamErrores ,
                                           A2085MigrLegFamWarnings ,
                                           A2081MigrLegFamDedGan ,
                                           Integer.valueOf(AV57Importarlegajofamiliads_1_clicod) ,
                                           Short.valueOf(AV58Importarlegajofamiliads_2_empcod) ,
                                           Integer.valueOf(AV59Importarlegajofamiliads_3_migrlegnumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A87MigrLegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT
                                           }
      });
      lV62Importarlegajofamiliads_6_tfmigrlegfamparen = GXutil.concat( GXutil.rtrim( AV62Importarlegajofamiliads_6_tfmigrlegfamparen), "%", "") ;
      lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = GXutil.concat( GXutil.rtrim( AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc), "%", "") ;
      lV68Importarlegajofamiliads_12_tfmigrlegfamadh = GXutil.padr( GXutil.rtrim( AV68Importarlegajofamiliads_12_tfmigrlegfamadh), 20, "%") ;
      /* Using cursor P01YP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV57Importarlegajofamiliads_1_clicod), Short.valueOf(AV58Importarlegajofamiliads_2_empcod), Integer.valueOf(AV59Importarlegajofamiliads_3_migrlegnumero), lV62Importarlegajofamiliads_6_tfmigrlegfamparen, lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc, AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan, AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to, lV68Importarlegajofamiliads_12_tfmigrlegfamadh});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1YP2 = false ;
         A3CliCod = P01YP2_A3CliCod[0] ;
         A1EmpCod = P01YP2_A1EmpCod[0] ;
         A87MigrLegNumero = P01YP2_A87MigrLegNumero[0] ;
         A2079MigrLegFamParen = P01YP2_A2079MigrLegFamParen[0] ;
         A2085MigrLegFamWarnings = P01YP2_A2085MigrLegFamWarnings[0] ;
         A2084MigrLegFamErrores = P01YP2_A2084MigrLegFamErrores[0] ;
         A2082MigrLegFamAdh = P01YP2_A2082MigrLegFamAdh[0] ;
         A2081MigrLegFamDedGan = P01YP2_A2081MigrLegFamDedGan[0] ;
         A2080MigrLegFamNroDoc = P01YP2_A2080MigrLegFamNroDoc[0] ;
         A2078MigrLegFamSec = P01YP2_A2078MigrLegFamSec[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01YP2_A3CliCod[0] == A3CliCod ) && ( P01YP2_A1EmpCod[0] == A1EmpCod ) && ( P01YP2_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( GXutil.strcmp(P01YP2_A2079MigrLegFamParen[0], A2079MigrLegFamParen) == 0 ) )
         {
            brk1YP2 = false ;
            A2078MigrLegFamSec = P01YP2_A2078MigrLegFamSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1YP2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2079MigrLegFamParen)==0) )
         {
            AV23Option = A2079MigrLegFamParen ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1YP2 )
         {
            brk1YP2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMIGRLEGFAMNRODOCOPTIONS' Routine */
      returnInSub = false ;
      AV15TFMigrLegFamNroDoc = AV35SearchTxt ;
      AV16TFMigrLegFamNroDoc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Importarlegajofamiliads_1_clicod = AV40CliCod ;
      AV58Importarlegajofamiliads_2_empcod = AV41EmpCod ;
      AV59Importarlegajofamiliads_3_migrlegnumero = AV42MigrLegNumero ;
      AV60Importarlegajofamiliads_4_tficonoupdate = AV43TFiconoUpdate ;
      AV61Importarlegajofamiliads_5_tficonoupdateoperator = AV44TFiconoUpdateOperator ;
      AV62Importarlegajofamiliads_6_tfmigrlegfamparen = AV12TFMigrLegFamParen ;
      AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV13TFMigrLegFamParen_Sels ;
      AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV15TFMigrLegFamNroDoc ;
      AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV16TFMigrLegFamNroDoc_Sels ;
      AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV17TFMigrLegFamDedGan ;
      AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV18TFMigrLegFamDedGan_To ;
      AV68Importarlegajofamiliads_12_tfmigrlegfamadh = AV20TFMigrLegFamAdh ;
      AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV21TFMigrLegFamAdh_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2079MigrLegFamParen ,
                                           AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                           A2080MigrLegFamNroDoc ,
                                           AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                           A2082MigrLegFamAdh ,
                                           AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                           Short.valueOf(AV61Importarlegajofamiliads_5_tficonoupdateoperator) ,
                                           Integer.valueOf(AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels.size()) ,
                                           AV62Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                           Integer.valueOf(AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels.size()) ,
                                           AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                           AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                           AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                           Integer.valueOf(AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels.size()) ,
                                           AV68Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                           A2084MigrLegFamErrores ,
                                           A2085MigrLegFamWarnings ,
                                           A2081MigrLegFamDedGan ,
                                           Integer.valueOf(AV57Importarlegajofamiliads_1_clicod) ,
                                           Short.valueOf(AV58Importarlegajofamiliads_2_empcod) ,
                                           Integer.valueOf(AV59Importarlegajofamiliads_3_migrlegnumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A87MigrLegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT
                                           }
      });
      lV62Importarlegajofamiliads_6_tfmigrlegfamparen = GXutil.concat( GXutil.rtrim( AV62Importarlegajofamiliads_6_tfmigrlegfamparen), "%", "") ;
      lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = GXutil.concat( GXutil.rtrim( AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc), "%", "") ;
      lV68Importarlegajofamiliads_12_tfmigrlegfamadh = GXutil.padr( GXutil.rtrim( AV68Importarlegajofamiliads_12_tfmigrlegfamadh), 20, "%") ;
      /* Using cursor P01YP3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV57Importarlegajofamiliads_1_clicod), Short.valueOf(AV58Importarlegajofamiliads_2_empcod), Integer.valueOf(AV59Importarlegajofamiliads_3_migrlegnumero), lV62Importarlegajofamiliads_6_tfmigrlegfamparen, lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc, AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan, AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to, lV68Importarlegajofamiliads_12_tfmigrlegfamadh});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1YP4 = false ;
         A3CliCod = P01YP3_A3CliCod[0] ;
         A1EmpCod = P01YP3_A1EmpCod[0] ;
         A87MigrLegNumero = P01YP3_A87MigrLegNumero[0] ;
         A2080MigrLegFamNroDoc = P01YP3_A2080MigrLegFamNroDoc[0] ;
         A2085MigrLegFamWarnings = P01YP3_A2085MigrLegFamWarnings[0] ;
         A2084MigrLegFamErrores = P01YP3_A2084MigrLegFamErrores[0] ;
         A2082MigrLegFamAdh = P01YP3_A2082MigrLegFamAdh[0] ;
         A2081MigrLegFamDedGan = P01YP3_A2081MigrLegFamDedGan[0] ;
         A2079MigrLegFamParen = P01YP3_A2079MigrLegFamParen[0] ;
         A2078MigrLegFamSec = P01YP3_A2078MigrLegFamSec[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01YP3_A3CliCod[0] == A3CliCod ) && ( P01YP3_A1EmpCod[0] == A1EmpCod ) && ( P01YP3_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( GXutil.strcmp(P01YP3_A2080MigrLegFamNroDoc[0], A2080MigrLegFamNroDoc) == 0 ) )
         {
            brk1YP4 = false ;
            A2078MigrLegFamSec = P01YP3_A2078MigrLegFamSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1YP4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2080MigrLegFamNroDoc)==0) )
         {
            AV23Option = A2080MigrLegFamNroDoc ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1YP4 )
         {
            brk1YP4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMIGRLEGFAMADHOPTIONS' Routine */
      returnInSub = false ;
      AV20TFMigrLegFamAdh = AV35SearchTxt ;
      AV21TFMigrLegFamAdh_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Importarlegajofamiliads_1_clicod = AV40CliCod ;
      AV58Importarlegajofamiliads_2_empcod = AV41EmpCod ;
      AV59Importarlegajofamiliads_3_migrlegnumero = AV42MigrLegNumero ;
      AV60Importarlegajofamiliads_4_tficonoupdate = AV43TFiconoUpdate ;
      AV61Importarlegajofamiliads_5_tficonoupdateoperator = AV44TFiconoUpdateOperator ;
      AV62Importarlegajofamiliads_6_tfmigrlegfamparen = AV12TFMigrLegFamParen ;
      AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV13TFMigrLegFamParen_Sels ;
      AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV15TFMigrLegFamNroDoc ;
      AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV16TFMigrLegFamNroDoc_Sels ;
      AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV17TFMigrLegFamDedGan ;
      AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV18TFMigrLegFamDedGan_To ;
      AV68Importarlegajofamiliads_12_tfmigrlegfamadh = AV20TFMigrLegFamAdh ;
      AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV21TFMigrLegFamAdh_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A2079MigrLegFamParen ,
                                           AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                           A2080MigrLegFamNroDoc ,
                                           AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                           A2082MigrLegFamAdh ,
                                           AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                           Short.valueOf(AV61Importarlegajofamiliads_5_tficonoupdateoperator) ,
                                           Integer.valueOf(AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels.size()) ,
                                           AV62Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                           Integer.valueOf(AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels.size()) ,
                                           AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                           AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                           AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                           Integer.valueOf(AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels.size()) ,
                                           AV68Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                           A2084MigrLegFamErrores ,
                                           A2085MigrLegFamWarnings ,
                                           A2081MigrLegFamDedGan ,
                                           Integer.valueOf(AV57Importarlegajofamiliads_1_clicod) ,
                                           Short.valueOf(AV58Importarlegajofamiliads_2_empcod) ,
                                           Integer.valueOf(AV59Importarlegajofamiliads_3_migrlegnumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A87MigrLegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT
                                           }
      });
      lV62Importarlegajofamiliads_6_tfmigrlegfamparen = GXutil.concat( GXutil.rtrim( AV62Importarlegajofamiliads_6_tfmigrlegfamparen), "%", "") ;
      lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = GXutil.concat( GXutil.rtrim( AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc), "%", "") ;
      lV68Importarlegajofamiliads_12_tfmigrlegfamadh = GXutil.padr( GXutil.rtrim( AV68Importarlegajofamiliads_12_tfmigrlegfamadh), 20, "%") ;
      /* Using cursor P01YP4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV57Importarlegajofamiliads_1_clicod), Short.valueOf(AV58Importarlegajofamiliads_2_empcod), Integer.valueOf(AV59Importarlegajofamiliads_3_migrlegnumero), lV62Importarlegajofamiliads_6_tfmigrlegfamparen, lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc, AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan, AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to, lV68Importarlegajofamiliads_12_tfmigrlegfamadh});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1YP6 = false ;
         A3CliCod = P01YP4_A3CliCod[0] ;
         A1EmpCod = P01YP4_A1EmpCod[0] ;
         A87MigrLegNumero = P01YP4_A87MigrLegNumero[0] ;
         A2082MigrLegFamAdh = P01YP4_A2082MigrLegFamAdh[0] ;
         A2085MigrLegFamWarnings = P01YP4_A2085MigrLegFamWarnings[0] ;
         A2084MigrLegFamErrores = P01YP4_A2084MigrLegFamErrores[0] ;
         A2081MigrLegFamDedGan = P01YP4_A2081MigrLegFamDedGan[0] ;
         A2080MigrLegFamNroDoc = P01YP4_A2080MigrLegFamNroDoc[0] ;
         A2079MigrLegFamParen = P01YP4_A2079MigrLegFamParen[0] ;
         A2078MigrLegFamSec = P01YP4_A2078MigrLegFamSec[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P01YP4_A3CliCod[0] == A3CliCod ) && ( P01YP4_A1EmpCod[0] == A1EmpCod ) && ( P01YP4_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( GXutil.strcmp(P01YP4_A2082MigrLegFamAdh[0], A2082MigrLegFamAdh) == 0 ) )
         {
            brk1YP6 = false ;
            A2078MigrLegFamSec = P01YP4_A2078MigrLegFamSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1YP6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2082MigrLegFamAdh)==0) )
         {
            AV23Option = A2082MigrLegFamAdh ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1YP6 )
         {
            brk1YP6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = importarlegajofamiliagetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = importarlegajofamiliagetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = importarlegajofamiliagetfilterdata.this.AV39OptionIndexesJson;
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
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV29Session = httpContext.getWebSession();
      AV31GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV32GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFMigrLegFamParen = "" ;
      AV11TFMigrLegFamParen_SelsJson = "" ;
      AV13TFMigrLegFamParen_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFMigrLegFamNroDoc = "" ;
      AV14TFMigrLegFamNroDoc_SelsJson = "" ;
      AV16TFMigrLegFamNroDoc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFMigrLegFamDedGan = DecimalUtil.ZERO ;
      AV18TFMigrLegFamDedGan_To = DecimalUtil.ZERO ;
      AV20TFMigrLegFamAdh = "" ;
      AV19TFMigrLegFamAdh_SelsJson = "" ;
      AV21TFMigrLegFamAdh_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A2079MigrLegFamParen = "" ;
      AV60Importarlegajofamiliads_4_tficonoupdate = "" ;
      AV43TFiconoUpdate = "" ;
      AV62Importarlegajofamiliads_6_tfmigrlegfamparen = "" ;
      AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = "" ;
      AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan = DecimalUtil.ZERO ;
      AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = DecimalUtil.ZERO ;
      AV68Importarlegajofamiliads_12_tfmigrlegfamadh = "" ;
      AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV62Importarlegajofamiliads_6_tfmigrlegfamparen = "" ;
      lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc = "" ;
      lV68Importarlegajofamiliads_12_tfmigrlegfamadh = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2082MigrLegFamAdh = "" ;
      A2084MigrLegFamErrores = "" ;
      A2085MigrLegFamWarnings = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      P01YP2_A3CliCod = new int[1] ;
      P01YP2_A1EmpCod = new short[1] ;
      P01YP2_A87MigrLegNumero = new int[1] ;
      P01YP2_A2079MigrLegFamParen = new String[] {""} ;
      P01YP2_A2085MigrLegFamWarnings = new String[] {""} ;
      P01YP2_A2084MigrLegFamErrores = new String[] {""} ;
      P01YP2_A2082MigrLegFamAdh = new String[] {""} ;
      P01YP2_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01YP2_A2080MigrLegFamNroDoc = new String[] {""} ;
      P01YP2_A2078MigrLegFamSec = new short[1] ;
      AV23Option = "" ;
      P01YP3_A3CliCod = new int[1] ;
      P01YP3_A1EmpCod = new short[1] ;
      P01YP3_A87MigrLegNumero = new int[1] ;
      P01YP3_A2080MigrLegFamNroDoc = new String[] {""} ;
      P01YP3_A2085MigrLegFamWarnings = new String[] {""} ;
      P01YP3_A2084MigrLegFamErrores = new String[] {""} ;
      P01YP3_A2082MigrLegFamAdh = new String[] {""} ;
      P01YP3_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01YP3_A2079MigrLegFamParen = new String[] {""} ;
      P01YP3_A2078MigrLegFamSec = new short[1] ;
      P01YP4_A3CliCod = new int[1] ;
      P01YP4_A1EmpCod = new short[1] ;
      P01YP4_A87MigrLegNumero = new int[1] ;
      P01YP4_A2082MigrLegFamAdh = new String[] {""} ;
      P01YP4_A2085MigrLegFamWarnings = new String[] {""} ;
      P01YP4_A2084MigrLegFamErrores = new String[] {""} ;
      P01YP4_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01YP4_A2080MigrLegFamNroDoc = new String[] {""} ;
      P01YP4_A2079MigrLegFamParen = new String[] {""} ;
      P01YP4_A2078MigrLegFamSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajofamiliagetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01YP2_A3CliCod, P01YP2_A1EmpCod, P01YP2_A87MigrLegNumero, P01YP2_A2079MigrLegFamParen, P01YP2_A2085MigrLegFamWarnings, P01YP2_A2084MigrLegFamErrores, P01YP2_A2082MigrLegFamAdh, P01YP2_A2081MigrLegFamDedGan, P01YP2_A2080MigrLegFamNroDoc, P01YP2_A2078MigrLegFamSec
            }
            , new Object[] {
            P01YP3_A3CliCod, P01YP3_A1EmpCod, P01YP3_A87MigrLegNumero, P01YP3_A2080MigrLegFamNroDoc, P01YP3_A2085MigrLegFamWarnings, P01YP3_A2084MigrLegFamErrores, P01YP3_A2082MigrLegFamAdh, P01YP3_A2081MigrLegFamDedGan, P01YP3_A2079MigrLegFamParen, P01YP3_A2078MigrLegFamSec
            }
            , new Object[] {
            P01YP4_A3CliCod, P01YP4_A1EmpCod, P01YP4_A87MigrLegNumero, P01YP4_A2082MigrLegFamAdh, P01YP4_A2085MigrLegFamWarnings, P01YP4_A2084MigrLegFamErrores, P01YP4_A2081MigrLegFamDedGan, P01YP4_A2080MigrLegFamNroDoc, P01YP4_A2079MigrLegFamParen, P01YP4_A2078MigrLegFamSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV44TFiconoUpdateOperator ;
   private short AV41EmpCod ;
   private short AV58Importarlegajofamiliads_2_empcod ;
   private short AV61Importarlegajofamiliads_5_tficonoupdateoperator ;
   private short A1EmpCod ;
   private short A2078MigrLegFamSec ;
   private short Gx_err ;
   private int AV55GXV1 ;
   private int AV40CliCod ;
   private int AV42MigrLegNumero ;
   private int AV57Importarlegajofamiliads_1_clicod ;
   private int AV59Importarlegajofamiliads_3_migrlegnumero ;
   private int AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ;
   private int AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ;
   private int AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private long AV28count ;
   private java.math.BigDecimal AV17TFMigrLegFamDedGan ;
   private java.math.BigDecimal AV18TFMigrLegFamDedGan_To ;
   private java.math.BigDecimal AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ;
   private java.math.BigDecimal AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String AV20TFMigrLegFamAdh ;
   private String AV60Importarlegajofamiliads_4_tficonoupdate ;
   private String AV43TFiconoUpdate ;
   private String AV68Importarlegajofamiliads_12_tfmigrlegfamadh ;
   private String scmdbuf ;
   private String lV68Importarlegajofamiliads_12_tfmigrlegfamadh ;
   private String A2082MigrLegFamAdh ;
   private boolean returnInSub ;
   private boolean brk1YP2 ;
   private boolean brk1YP4 ;
   private boolean brk1YP6 ;
   private String AV37OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV39OptionIndexesJson ;
   private String AV11TFMigrLegFamParen_SelsJson ;
   private String AV14TFMigrLegFamNroDoc_SelsJson ;
   private String AV19TFMigrLegFamAdh_SelsJson ;
   private String A2084MigrLegFamErrores ;
   private String A2085MigrLegFamWarnings ;
   private String AV34DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV12TFMigrLegFamParen ;
   private String AV15TFMigrLegFamNroDoc ;
   private String A2079MigrLegFamParen ;
   private String AV62Importarlegajofamiliads_6_tfmigrlegfamparen ;
   private String AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ;
   private String lV62Importarlegajofamiliads_6_tfmigrlegfamparen ;
   private String lV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ;
   private String A2080MigrLegFamNroDoc ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01YP2_A3CliCod ;
   private short[] P01YP2_A1EmpCod ;
   private int[] P01YP2_A87MigrLegNumero ;
   private String[] P01YP2_A2079MigrLegFamParen ;
   private String[] P01YP2_A2085MigrLegFamWarnings ;
   private String[] P01YP2_A2084MigrLegFamErrores ;
   private String[] P01YP2_A2082MigrLegFamAdh ;
   private java.math.BigDecimal[] P01YP2_A2081MigrLegFamDedGan ;
   private String[] P01YP2_A2080MigrLegFamNroDoc ;
   private short[] P01YP2_A2078MigrLegFamSec ;
   private int[] P01YP3_A3CliCod ;
   private short[] P01YP3_A1EmpCod ;
   private int[] P01YP3_A87MigrLegNumero ;
   private String[] P01YP3_A2080MigrLegFamNroDoc ;
   private String[] P01YP3_A2085MigrLegFamWarnings ;
   private String[] P01YP3_A2084MigrLegFamErrores ;
   private String[] P01YP3_A2082MigrLegFamAdh ;
   private java.math.BigDecimal[] P01YP3_A2081MigrLegFamDedGan ;
   private String[] P01YP3_A2079MigrLegFamParen ;
   private short[] P01YP3_A2078MigrLegFamSec ;
   private int[] P01YP4_A3CliCod ;
   private short[] P01YP4_A1EmpCod ;
   private int[] P01YP4_A87MigrLegNumero ;
   private String[] P01YP4_A2082MigrLegFamAdh ;
   private String[] P01YP4_A2085MigrLegFamWarnings ;
   private String[] P01YP4_A2084MigrLegFamErrores ;
   private java.math.BigDecimal[] P01YP4_A2081MigrLegFamDedGan ;
   private String[] P01YP4_A2080MigrLegFamNroDoc ;
   private String[] P01YP4_A2079MigrLegFamParen ;
   private short[] P01YP4_A2078MigrLegFamSec ;
   private GXSimpleCollection<String> AV21TFMigrLegFamAdh_Sels ;
   private GXSimpleCollection<String> AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV13TFMigrLegFamParen_Sels ;
   private GXSimpleCollection<String> AV16TFMigrLegFamNroDoc_Sels ;
   private GXSimpleCollection<String> AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ;
   private GXSimpleCollection<String> AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class importarlegajofamiliagetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01YP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2079MigrLegFamParen ,
                                          GXSimpleCollection<String> AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                          String A2080MigrLegFamNroDoc ,
                                          GXSimpleCollection<String> AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                          String A2082MigrLegFamAdh ,
                                          GXSimpleCollection<String> AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                          short AV61Importarlegajofamiliads_5_tficonoupdateoperator ,
                                          int AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ,
                                          String AV62Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                          int AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ,
                                          String AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                          java.math.BigDecimal AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                          java.math.BigDecimal AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                          int AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ,
                                          String AV68Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                          String A2084MigrLegFamErrores ,
                                          String A2085MigrLegFamWarnings ,
                                          java.math.BigDecimal A2081MigrLegFamDedGan ,
                                          int AV57Importarlegajofamiliads_1_clicod ,
                                          short AV58Importarlegajofamiliads_2_empcod ,
                                          int AV59Importarlegajofamiliads_3_migrlegnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A87MigrLegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[8];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamParen, MigrLegFamWarnings, MigrLegFamErrores, MigrLegFamAdh, MigrLegFamDedGan, MigrLegFamNroDoc, MigrLegFamSec FROM" ;
      scmdbuf += " importacion_legajoFamilia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and MigrLegNumero = ?)");
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegFamErrores))=0))");
      }
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( ( AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Importarlegajofamiliads_6_tfmigrlegfamparen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamParen) like LOWER(?))");
      }
      else
      {
         GXv_int2[3] = (byte)(1) ;
      }
      if ( AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels, "MigrLegFamParen IN (", ")")+")");
      }
      if ( ( AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamNroDoc) like LOWER(?))");
      }
      else
      {
         GXv_int2[4] = (byte)(1) ;
      }
      if ( AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels, "MigrLegFamNroDoc IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan >= ?)");
      }
      else
      {
         GXv_int2[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan <= ?)");
      }
      else
      {
         GXv_int2[6] = (byte)(1) ;
      }
      if ( ( AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Importarlegajofamiliads_12_tfmigrlegfamadh)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamAdh) like LOWER(?))");
      }
      else
      {
         GXv_int2[7] = (byte)(1) ;
      }
      if ( AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels, "MigrLegFamAdh IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamParen" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P01YP3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2079MigrLegFamParen ,
                                          GXSimpleCollection<String> AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                          String A2080MigrLegFamNroDoc ,
                                          GXSimpleCollection<String> AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                          String A2082MigrLegFamAdh ,
                                          GXSimpleCollection<String> AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                          short AV61Importarlegajofamiliads_5_tficonoupdateoperator ,
                                          int AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ,
                                          String AV62Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                          int AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ,
                                          String AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                          java.math.BigDecimal AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                          java.math.BigDecimal AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                          int AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ,
                                          String AV68Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                          String A2084MigrLegFamErrores ,
                                          String A2085MigrLegFamWarnings ,
                                          java.math.BigDecimal A2081MigrLegFamDedGan ,
                                          int AV57Importarlegajofamiliads_1_clicod ,
                                          short AV58Importarlegajofamiliads_2_empcod ,
                                          int AV59Importarlegajofamiliads_3_migrlegnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A87MigrLegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[8];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamNroDoc, MigrLegFamWarnings, MigrLegFamErrores, MigrLegFamAdh, MigrLegFamDedGan, MigrLegFamParen, MigrLegFamSec FROM" ;
      scmdbuf += " importacion_legajoFamilia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and MigrLegNumero = ?)");
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegFamErrores))=0))");
      }
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( ( AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Importarlegajofamiliads_6_tfmigrlegfamparen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamParen) like LOWER(?))");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      if ( AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels, "MigrLegFamParen IN (", ")")+")");
      }
      if ( ( AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamNroDoc) like LOWER(?))");
      }
      else
      {
         GXv_int5[4] = (byte)(1) ;
      }
      if ( AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels, "MigrLegFamNroDoc IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan >= ?)");
      }
      else
      {
         GXv_int5[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan <= ?)");
      }
      else
      {
         GXv_int5[6] = (byte)(1) ;
      }
      if ( ( AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Importarlegajofamiliads_12_tfmigrlegfamadh)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamAdh) like LOWER(?))");
      }
      else
      {
         GXv_int5[7] = (byte)(1) ;
      }
      if ( AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels, "MigrLegFamAdh IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamNroDoc" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   protected Object[] conditional_P01YP4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2079MigrLegFamParen ,
                                          GXSimpleCollection<String> AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                          String A2080MigrLegFamNroDoc ,
                                          GXSimpleCollection<String> AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                          String A2082MigrLegFamAdh ,
                                          GXSimpleCollection<String> AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                          short AV61Importarlegajofamiliads_5_tficonoupdateoperator ,
                                          int AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ,
                                          String AV62Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                          int AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ,
                                          String AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                          java.math.BigDecimal AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                          java.math.BigDecimal AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                          int AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ,
                                          String AV68Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                          String A2084MigrLegFamErrores ,
                                          String A2085MigrLegFamWarnings ,
                                          java.math.BigDecimal A2081MigrLegFamDedGan ,
                                          int AV57Importarlegajofamiliads_1_clicod ,
                                          short AV58Importarlegajofamiliads_2_empcod ,
                                          int AV59Importarlegajofamiliads_3_migrlegnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A87MigrLegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamAdh, MigrLegFamWarnings, MigrLegFamErrores, MigrLegFamDedGan, MigrLegFamNroDoc, MigrLegFamParen, MigrLegFamSec FROM" ;
      scmdbuf += " importacion_legajoFamilia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and MigrLegNumero = ?)");
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegFamErrores))=0))");
      }
      if ( AV61Importarlegajofamiliads_5_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( ( AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Importarlegajofamiliads_6_tfmigrlegfamparen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamParen) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Importarlegajofamiliads_7_tfmigrlegfamparen_sels, "MigrLegFamParen IN (", ")")+")");
      }
      if ( ( AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Importarlegajofamiliads_8_tfmigrlegfamnrodoc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamNroDoc) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels, "MigrLegFamNroDoc IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Importarlegajofamiliads_10_tfmigrlegfamdedgan)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Importarlegajofamiliads_11_tfmigrlegfamdedgan_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Importarlegajofamiliads_12_tfmigrlegfamadh)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamAdh) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Importarlegajofamiliads_13_tfmigrlegfamadh_sels, "MigrLegFamAdh IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamAdh" ;
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
                  return conditional_P01YP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() );
            case 1 :
                  return conditional_P01YP3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() );
            case 2 :
                  return conditional_P01YP4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01YP3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01YP4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               return;
      }
   }

}


package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisextraordinariaswwgetfilterdata extends GXProcedure
{
   public paisextraordinariaswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinariaswwgetfilterdata.class ), "" );
   }

   public paisextraordinariaswwgetfilterdata( int remoteHandle ,
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
      paisextraordinariaswwgetfilterdata.this.aP5 = new String[] {""};
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
      paisextraordinariaswwgetfilterdata.this.AV34DDOName = aP0;
      paisextraordinariaswwgetfilterdata.this.AV35SearchTxt = aP1;
      paisextraordinariaswwgetfilterdata.this.AV36SearchTxtTo = aP2;
      paisextraordinariaswwgetfilterdata.this.aP3 = aP3;
      paisextraordinariaswwgetfilterdata.this.aP4 = aP4;
      paisextraordinariaswwgetfilterdata.this.aP5 = aP5;
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
      paisextraordinariaswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV41EmpCod = GXt_int1 ;
      GXt_int3 = AV42CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      paisextraordinariaswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV42CliCod = GXt_int3 ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias", GXv_boolean6) ;
      paisextraordinariaswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_PAIHSPDIADESDE") == 0 )
         {
            /* Execute user subroutine: 'LOADPAIHSPDIADESDEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_PAIEXTRAORDRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADPAIEXTRAORDRELREFOPTIONS' */
            S131 ();
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
      if ( GXutil.strcmp(AV29Session.getValue("PaisExtraordinariasWWGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisExtraordinariasWWGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("PaisExtraordinariasWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIATIPTRA_SEL") == 0 )
         {
            AV11TFPaiHsPDiaTipTra_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFPaiHsPDiaTipTra_Sels.fromJSonString(AV11TFPaiHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADIA_SEL") == 0 )
         {
            AV13TFPaiHsPDiaDia_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV14TFPaiHsPDiaDia_Sels.fromJSonString(AV13TFPaiHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADESDE") == 0 )
         {
            AV16TFPaiHsPDiaDesde = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADESDE_SEL") == 0 )
         {
            AV15TFPaiHsPDiaDesde_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFPaiHsPDiaDesde_Sels.fromJSonString(AV15TFPaiHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDIA") == 0 )
         {
            AV18TFPaiTarifaPDia = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV19TFPaiTarifaPDia_To = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDREC") == 0 )
         {
            AV20TFPaiTarifaPDRec = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV21TFPaiTarifaPDRec_To = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDCRI_SEL") == 0 )
         {
            AV48TFPaiTarifaPDCri_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFPaiTarifaPDCri_Sels.fromJSonString(AV48TFPaiTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXTRAORDRELREF") == 0 )
         {
            AV46TFPaiExtraordRelRef = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXTRAORDRELREF_SEL") == 0 )
         {
            AV45TFPaiExtraordRelRef_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFPaiExtraordRelRef_Sels.fromJSonString(AV45TFPaiExtraordRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV44MenuOpcCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPAIHSPDIADESDEOPTIONS' Routine */
      returnInSub = false ;
      AV16TFPaiHsPDiaDesde = AV35SearchTxt ;
      AV17TFPaiHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV12TFPaiHsPDiaTipTra_Sels ;
      AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV14TFPaiHsPDiaDia_Sels ;
      AV56Paisextraordinariaswwds_3_tfpaihspdiadesde = AV16TFPaiHsPDiaDesde ;
      AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV17TFPaiHsPDiaDesde_Sels ;
      AV58Paisextraordinariaswwds_5_tfpaitarifapdia = AV18TFPaiTarifaPDia ;
      AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV19TFPaiTarifaPDia_To ;
      AV60Paisextraordinariaswwds_7_tfpaitarifapdrec = AV20TFPaiTarifaPDRec ;
      AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV21TFPaiTarifaPDRec_To ;
      AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV49TFPaiTarifaPDCri_Sels ;
      AV63Paisextraordinariaswwds_10_tfpaiextraordrelref = AV46TFPaiExtraordRelRef ;
      AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV47TFPaiExtraordRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1331PaiHsPDiaTipTra ,
                                           AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                           Byte.valueOf(A1333PaiHsPDiaDia) ,
                                           AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                           A1334PaiHsPDiaDesde ,
                                           AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                           A2434PaiTarifaPDCri ,
                                           AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                           A2058PaiExtraordRelRef ,
                                           AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                           Integer.valueOf(AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels.size()) ,
                                           Integer.valueOf(AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels.size()) ,
                                           AV56Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                           AV58Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                           AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                           AV60Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                           AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                           Integer.valueOf(AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels.size()) ,
                                           AV63Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                           Short.valueOf(AV43PaiCod) ,
                                           A1335PaiTarifaPDia ,
                                           A1348PaiTarifaPDRec ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT
                                           }
      });
      lV56Paisextraordinariaswwds_3_tfpaihspdiadesde = GXutil.padr( GXutil.rtrim( AV56Paisextraordinariaswwds_3_tfpaihspdiadesde), 5, "%") ;
      lV63Paisextraordinariaswwds_10_tfpaiextraordrelref = GXutil.concat( GXutil.rtrim( AV63Paisextraordinariaswwds_10_tfpaiextraordrelref), "%", "") ;
      /* Using cursor P01N92 */
      pr_default.execute(0, new Object[] {lV56Paisextraordinariaswwds_3_tfpaihspdiadesde, AV58Paisextraordinariaswwds_5_tfpaitarifapdia, AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to, AV60Paisextraordinariaswwds_7_tfpaitarifapdrec, AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to, lV63Paisextraordinariaswwds_10_tfpaiextraordrelref, Short.valueOf(AV43PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1N92 = false ;
         A1334PaiHsPDiaDesde = P01N92_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = P01N92_n1334PaiHsPDiaDesde[0] ;
         A46PaiCod = P01N92_A46PaiCod[0] ;
         A2058PaiExtraordRelRef = P01N92_A2058PaiExtraordRelRef[0] ;
         A2434PaiTarifaPDCri = P01N92_A2434PaiTarifaPDCri[0] ;
         A1348PaiTarifaPDRec = P01N92_A1348PaiTarifaPDRec[0] ;
         A1335PaiTarifaPDia = P01N92_A1335PaiTarifaPDia[0] ;
         A1333PaiHsPDiaDia = P01N92_A1333PaiHsPDiaDia[0] ;
         A1331PaiHsPDiaTipTra = P01N92_A1331PaiHsPDiaTipTra[0] ;
         A1332PaiHsExSec = P01N92_A1332PaiHsExSec[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01N92_A1334PaiHsPDiaDesde[0], A1334PaiHsPDiaDesde) == 0 ) )
         {
            brk1N92 = false ;
            A46PaiCod = P01N92_A46PaiCod[0] ;
            A1332PaiHsExSec = P01N92_A1332PaiHsExSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1N92 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1334PaiHsPDiaDesde)==0) )
         {
            AV23Option = A1334PaiHsPDiaDesde ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1N92 )
         {
            brk1N92 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPAIEXTRAORDRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV46TFPaiExtraordRelRef = AV35SearchTxt ;
      AV47TFPaiExtraordRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV12TFPaiHsPDiaTipTra_Sels ;
      AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV14TFPaiHsPDiaDia_Sels ;
      AV56Paisextraordinariaswwds_3_tfpaihspdiadesde = AV16TFPaiHsPDiaDesde ;
      AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV17TFPaiHsPDiaDesde_Sels ;
      AV58Paisextraordinariaswwds_5_tfpaitarifapdia = AV18TFPaiTarifaPDia ;
      AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV19TFPaiTarifaPDia_To ;
      AV60Paisextraordinariaswwds_7_tfpaitarifapdrec = AV20TFPaiTarifaPDRec ;
      AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV21TFPaiTarifaPDRec_To ;
      AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV49TFPaiTarifaPDCri_Sels ;
      AV63Paisextraordinariaswwds_10_tfpaiextraordrelref = AV46TFPaiExtraordRelRef ;
      AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV47TFPaiExtraordRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1331PaiHsPDiaTipTra ,
                                           AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                           Byte.valueOf(A1333PaiHsPDiaDia) ,
                                           AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                           A1334PaiHsPDiaDesde ,
                                           AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                           A2434PaiTarifaPDCri ,
                                           AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                           A2058PaiExtraordRelRef ,
                                           AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                           Integer.valueOf(AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels.size()) ,
                                           Integer.valueOf(AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels.size()) ,
                                           AV56Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                           AV58Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                           AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                           AV60Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                           AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                           Integer.valueOf(AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels.size()) ,
                                           AV63Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                           Short.valueOf(AV43PaiCod) ,
                                           A1335PaiTarifaPDia ,
                                           A1348PaiTarifaPDRec ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT
                                           }
      });
      lV56Paisextraordinariaswwds_3_tfpaihspdiadesde = GXutil.padr( GXutil.rtrim( AV56Paisextraordinariaswwds_3_tfpaihspdiadesde), 5, "%") ;
      lV63Paisextraordinariaswwds_10_tfpaiextraordrelref = GXutil.concat( GXutil.rtrim( AV63Paisextraordinariaswwds_10_tfpaiextraordrelref), "%", "") ;
      /* Using cursor P01N93 */
      pr_default.execute(1, new Object[] {lV56Paisextraordinariaswwds_3_tfpaihspdiadesde, AV58Paisextraordinariaswwds_5_tfpaitarifapdia, AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to, AV60Paisextraordinariaswwds_7_tfpaitarifapdrec, AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to, lV63Paisextraordinariaswwds_10_tfpaiextraordrelref, Short.valueOf(AV43PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1N94 = false ;
         A2058PaiExtraordRelRef = P01N93_A2058PaiExtraordRelRef[0] ;
         A46PaiCod = P01N93_A46PaiCod[0] ;
         A2434PaiTarifaPDCri = P01N93_A2434PaiTarifaPDCri[0] ;
         A1348PaiTarifaPDRec = P01N93_A1348PaiTarifaPDRec[0] ;
         A1335PaiTarifaPDia = P01N93_A1335PaiTarifaPDia[0] ;
         A1334PaiHsPDiaDesde = P01N93_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = P01N93_n1334PaiHsPDiaDesde[0] ;
         A1333PaiHsPDiaDia = P01N93_A1333PaiHsPDiaDia[0] ;
         A1331PaiHsPDiaTipTra = P01N93_A1331PaiHsPDiaTipTra[0] ;
         A1332PaiHsExSec = P01N93_A1332PaiHsExSec[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01N93_A2058PaiExtraordRelRef[0], A2058PaiExtraordRelRef) == 0 ) )
         {
            brk1N94 = false ;
            A46PaiCod = P01N93_A46PaiCod[0] ;
            A1332PaiHsExSec = P01N93_A1332PaiHsExSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1N94 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2058PaiExtraordRelRef)==0) )
         {
            AV23Option = A2058PaiExtraordRelRef ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1N94 )
         {
            brk1N94 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = paisextraordinariaswwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = paisextraordinariaswwgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = paisextraordinariaswwgetfilterdata.this.AV39OptionIndexesJson;
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
      AV11TFPaiHsPDiaTipTra_SelsJson = "" ;
      AV12TFPaiHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13TFPaiHsPDiaDia_SelsJson = "" ;
      AV14TFPaiHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV16TFPaiHsPDiaDesde = "" ;
      AV15TFPaiHsPDiaDesde_SelsJson = "" ;
      AV17TFPaiHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFPaiTarifaPDia = DecimalUtil.ZERO ;
      AV19TFPaiTarifaPDia_To = DecimalUtil.ZERO ;
      AV20TFPaiTarifaPDRec = DecimalUtil.ZERO ;
      AV21TFPaiTarifaPDRec_To = DecimalUtil.ZERO ;
      AV48TFPaiTarifaPDCri_SelsJson = "" ;
      AV49TFPaiTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFPaiExtraordRelRef = "" ;
      AV45TFPaiExtraordRelRef_SelsJson = "" ;
      AV47TFPaiExtraordRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44MenuOpcCod = "" ;
      A1334PaiHsPDiaDesde = "" ;
      AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV56Paisextraordinariaswwds_3_tfpaihspdiadesde = "" ;
      AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58Paisextraordinariaswwds_5_tfpaitarifapdia = DecimalUtil.ZERO ;
      AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to = DecimalUtil.ZERO ;
      AV60Paisextraordinariaswwds_7_tfpaitarifapdrec = DecimalUtil.ZERO ;
      AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to = DecimalUtil.ZERO ;
      AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Paisextraordinariaswwds_10_tfpaiextraordrelref = "" ;
      AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV56Paisextraordinariaswwds_3_tfpaihspdiadesde = "" ;
      lV63Paisextraordinariaswwds_10_tfpaiextraordrelref = "" ;
      A1331PaiHsPDiaTipTra = "" ;
      A2434PaiTarifaPDCri = "" ;
      A2058PaiExtraordRelRef = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      P01N92_A1334PaiHsPDiaDesde = new String[] {""} ;
      P01N92_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      P01N92_A46PaiCod = new short[1] ;
      P01N92_A2058PaiExtraordRelRef = new String[] {""} ;
      P01N92_A2434PaiTarifaPDCri = new String[] {""} ;
      P01N92_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01N92_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01N92_A1333PaiHsPDiaDia = new byte[1] ;
      P01N92_A1331PaiHsPDiaTipTra = new String[] {""} ;
      P01N92_A1332PaiHsExSec = new short[1] ;
      AV23Option = "" ;
      P01N93_A2058PaiExtraordRelRef = new String[] {""} ;
      P01N93_A46PaiCod = new short[1] ;
      P01N93_A2434PaiTarifaPDCri = new String[] {""} ;
      P01N93_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01N93_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01N93_A1334PaiHsPDiaDesde = new String[] {""} ;
      P01N93_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      P01N93_A1333PaiHsPDiaDia = new byte[1] ;
      P01N93_A1331PaiHsPDiaTipTra = new String[] {""} ;
      P01N93_A1332PaiHsExSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisextraordinariaswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01N92_A1334PaiHsPDiaDesde, P01N92_n1334PaiHsPDiaDesde, P01N92_A46PaiCod, P01N92_A2058PaiExtraordRelRef, P01N92_A2434PaiTarifaPDCri, P01N92_A1348PaiTarifaPDRec, P01N92_A1335PaiTarifaPDia, P01N92_A1333PaiHsPDiaDia, P01N92_A1331PaiHsPDiaTipTra, P01N92_A1332PaiHsExSec
            }
            , new Object[] {
            P01N93_A2058PaiExtraordRelRef, P01N93_A46PaiCod, P01N93_A2434PaiTarifaPDCri, P01N93_A1348PaiTarifaPDRec, P01N93_A1335PaiTarifaPDia, P01N93_A1334PaiHsPDiaDesde, P01N93_n1334PaiHsPDiaDesde, P01N93_A1333PaiHsPDiaDia, P01N93_A1331PaiHsPDiaTipTra, P01N93_A1332PaiHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1333PaiHsPDiaDia ;
   private short AV41EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV43PaiCod ;
   private short A46PaiCod ;
   private short A1332PaiHsExSec ;
   private short Gx_err ;
   private int AV42CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV52GXV1 ;
   private int AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ;
   private int AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ;
   private int AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ;
   private int AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ;
   private int AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ;
   private long AV28count ;
   private java.math.BigDecimal AV18TFPaiTarifaPDia ;
   private java.math.BigDecimal AV19TFPaiTarifaPDia_To ;
   private java.math.BigDecimal AV20TFPaiTarifaPDRec ;
   private java.math.BigDecimal AV21TFPaiTarifaPDRec_To ;
   private java.math.BigDecimal AV58Paisextraordinariaswwds_5_tfpaitarifapdia ;
   private java.math.BigDecimal AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to ;
   private java.math.BigDecimal AV60Paisextraordinariaswwds_7_tfpaitarifapdrec ;
   private java.math.BigDecimal AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private String AV16TFPaiHsPDiaDesde ;
   private String A1334PaiHsPDiaDesde ;
   private String AV56Paisextraordinariaswwds_3_tfpaihspdiadesde ;
   private String scmdbuf ;
   private String lV56Paisextraordinariaswwds_3_tfpaihspdiadesde ;
   private String A1331PaiHsPDiaTipTra ;
   private String A2434PaiTarifaPDCri ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1N92 ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean brk1N94 ;
   private String AV37OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV39OptionIndexesJson ;
   private String AV11TFPaiHsPDiaTipTra_SelsJson ;
   private String AV13TFPaiHsPDiaDia_SelsJson ;
   private String AV15TFPaiHsPDiaDesde_SelsJson ;
   private String AV48TFPaiTarifaPDCri_SelsJson ;
   private String AV45TFPaiExtraordRelRef_SelsJson ;
   private String AV34DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV46TFPaiExtraordRelRef ;
   private String AV44MenuOpcCod ;
   private String AV63Paisextraordinariaswwds_10_tfpaiextraordrelref ;
   private String lV63Paisextraordinariaswwds_10_tfpaiextraordrelref ;
   private String A2058PaiExtraordRelRef ;
   private String AV23Option ;
   private GXSimpleCollection<Byte> AV14TFPaiHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01N92_A1334PaiHsPDiaDesde ;
   private boolean[] P01N92_n1334PaiHsPDiaDesde ;
   private short[] P01N92_A46PaiCod ;
   private String[] P01N92_A2058PaiExtraordRelRef ;
   private String[] P01N92_A2434PaiTarifaPDCri ;
   private java.math.BigDecimal[] P01N92_A1348PaiTarifaPDRec ;
   private java.math.BigDecimal[] P01N92_A1335PaiTarifaPDia ;
   private byte[] P01N92_A1333PaiHsPDiaDia ;
   private String[] P01N92_A1331PaiHsPDiaTipTra ;
   private short[] P01N92_A1332PaiHsExSec ;
   private String[] P01N93_A2058PaiExtraordRelRef ;
   private short[] P01N93_A46PaiCod ;
   private String[] P01N93_A2434PaiTarifaPDCri ;
   private java.math.BigDecimal[] P01N93_A1348PaiTarifaPDRec ;
   private java.math.BigDecimal[] P01N93_A1335PaiTarifaPDia ;
   private String[] P01N93_A1334PaiHsPDiaDesde ;
   private boolean[] P01N93_n1334PaiHsPDiaDesde ;
   private byte[] P01N93_A1333PaiHsPDiaDia ;
   private String[] P01N93_A1331PaiHsPDiaTipTra ;
   private short[] P01N93_A1332PaiHsExSec ;
   private GXSimpleCollection<String> AV12TFPaiHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV17TFPaiHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV49TFPaiTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ;
   private GXSimpleCollection<String> AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ;
   private GXSimpleCollection<String> AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV47TFPaiExtraordRelRef_Sels ;
   private GXSimpleCollection<String> AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class paisextraordinariaswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01N92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1331PaiHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                          byte A1333PaiHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                          String A1334PaiHsPDiaDesde ,
                                          GXSimpleCollection<String> AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                          String A2434PaiTarifaPDCri ,
                                          GXSimpleCollection<String> AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                          String A2058PaiExtraordRelRef ,
                                          GXSimpleCollection<String> AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                          int AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ,
                                          int AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ,
                                          int AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ,
                                          String AV56Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                          java.math.BigDecimal AV58Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                          java.math.BigDecimal AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                          java.math.BigDecimal AV60Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                          java.math.BigDecimal AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                          int AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ,
                                          int AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ,
                                          String AV63Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                          short AV43PaiCod ,
                                          java.math.BigDecimal A1335PaiTarifaPDia ,
                                          java.math.BigDecimal A1348PaiTarifaPDRec ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PaiHsPDiaDesde, PaiCod, PaiExtraordRelRef, PaiTarifaPDCri, PaiTarifaPDRec, PaiTarifaPDia, PaiHsPDiaDia, PaiHsPDiaTipTra, PaiHsExSec FROM Paishorasextras_pordia" ;
      if ( AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels, "PaiHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels, "PaiHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Paisextraordinariaswwds_3_tfpaihspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels, "PaiHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Paisextraordinariaswwds_5_tfpaitarifapdia)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60Paisextraordinariaswwds_7_tfpaitarifapdrec)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels, "PaiTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Paisextraordinariaswwds_10_tfpaiextraordrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiExtraordRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels, "PaiExtraordRelRef IN (", ")")+")");
      }
      if ( ! (0==AV43PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiHsPDiaDesde" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01N93( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1331PaiHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                          byte A1333PaiHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                          String A1334PaiHsPDiaDesde ,
                                          GXSimpleCollection<String> AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                          String A2434PaiTarifaPDCri ,
                                          GXSimpleCollection<String> AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                          String A2058PaiExtraordRelRef ,
                                          GXSimpleCollection<String> AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                          int AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ,
                                          int AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ,
                                          int AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ,
                                          String AV56Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                          java.math.BigDecimal AV58Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                          java.math.BigDecimal AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                          java.math.BigDecimal AV60Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                          java.math.BigDecimal AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                          int AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ,
                                          int AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ,
                                          String AV63Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                          short AV43PaiCod ,
                                          java.math.BigDecimal A1335PaiTarifaPDia ,
                                          java.math.BigDecimal A1348PaiTarifaPDRec ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[7];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT PaiExtraordRelRef, PaiCod, PaiTarifaPDCri, PaiTarifaPDRec, PaiTarifaPDia, PaiHsPDiaDesde, PaiHsPDiaDia, PaiHsPDiaTipTra, PaiHsExSec FROM Paishorasextras_pordia" ;
      if ( AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels, "PaiHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Paisextraordinariaswwds_2_tfpaihspdiadia_sels, "PaiHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Paisextraordinariaswwds_3_tfpaihspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Paisextraordinariaswwds_4_tfpaihspdiadesde_sels, "PaiHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Paisextraordinariaswwds_5_tfpaitarifapdia)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Paisextraordinariaswwds_6_tfpaitarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60Paisextraordinariaswwds_7_tfpaitarifapdrec)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Paisextraordinariaswwds_8_tfpaitarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Paisextraordinariaswwds_9_tfpaitarifapdcri_sels, "PaiTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Paisextraordinariaswwds_10_tfpaiextraordrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiExtraordRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Paisextraordinariaswwds_11_tfpaiextraordrelref_sels, "PaiExtraordRelRef IN (", ")")+")");
      }
      if ( ! (0==AV43PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiExtraordRelRef" ;
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
                  return conditional_P01N92(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() );
            case 1 :
                  return conditional_P01N93(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01N92", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01N93", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 5);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
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
                  stmt.setString(sIdx, (String)parms[7], 5);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 5);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}


package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conveniowwgetfilterdata extends GXProcedure
{
   public conveniowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniowwgetfilterdata.class ), "" );
   }

   public conveniowwgetfilterdata( int remoteHandle ,
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
      conveniowwgetfilterdata.this.aP5 = new String[] {""};
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
      conveniowwgetfilterdata.this.AV20DDOName = aP0;
      conveniowwgetfilterdata.this.AV18SearchTxt = aP1;
      conveniowwgetfilterdata.this.AV19SearchTxtTo = aP2;
      conveniowwgetfilterdata.this.aP3 = aP3;
      conveniowwgetfilterdata.this.aP4 = aP4;
      conveniowwgetfilterdata.this.aP5 = aP5;
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
      conveniowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV43CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      conveniowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV43CliCod = GXt_int3 ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio", GXv_boolean6) ;
      conveniowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV20DDOName), "DDO_CONVECODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVECODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV20DDOName), "DDO_CONVEDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEDESCRIOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV20DDOName), "DDO_CONVESINDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVESINDESCOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV24OptionsJson = AV23Options.toJSonString(false) ;
      AV27OptionsDescJson = AV26OptionsDesc.toJSonString(false) ;
      AV29OptionIndexesJson = AV28OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("ConvenioWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConvenioWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("ConvenioWWGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVECODIGO") == 0 )
         {
            AV12TFConveCodigo = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVECODIGO_SEL") == 0 )
         {
            AV11TFConveCodigo_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFConveCodigo_Sels.fromJSonString(AV11TFConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEDESCRI") == 0 )
         {
            AV15TFConveDescri = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEDESCRI_SEL") == 0 )
         {
            AV14TFConveDescri_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFConveDescri_Sels.fromJSonString(AV14TFConveDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVESINDESC") == 0 )
         {
            AV47TFConveSinDesc = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVESINDESC_SEL") == 0 )
         {
            AV46TFConveSinDesc_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFConveSinDesc_Sels.fromJSonString(AV46TFConveSinDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEESCFRECACT") == 0 )
         {
            AV52TFConveEscFrecAct = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV53TFConveEscFrecAct_To = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV51MenuOpcCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVECODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV12TFConveCodigo = AV18SearchTxt ;
      AV13TFConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Conveniowwds_1_tfconvecodigo = AV12TFConveCodigo ;
      AV59Conveniowwds_2_tfconvecodigo_sels = AV13TFConveCodigo_Sels ;
      AV60Conveniowwds_3_tfconvedescri = AV15TFConveDescri ;
      AV61Conveniowwds_4_tfconvedescri_sels = AV16TFConveDescri_Sels ;
      AV62Conveniowwds_5_tfconvesindesc = AV47TFConveSinDesc ;
      AV63Conveniowwds_6_tfconvesindesc_sels = AV48TFConveSinDesc_Sels ;
      AV64Conveniowwds_7_tfconveescfrecact = AV52TFConveEscFrecAct ;
      AV65Conveniowwds_8_tfconveescfrecact_to = AV53TFConveEscFrecAct_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A9ConveCodigo ,
                                           AV59Conveniowwds_2_tfconvecodigo_sels ,
                                           A160ConveDescri ,
                                           AV61Conveniowwds_4_tfconvedescri_sels ,
                                           A936ConveSinDesc ,
                                           AV63Conveniowwds_6_tfconvesindesc_sels ,
                                           Integer.valueOf(AV59Conveniowwds_2_tfconvecodigo_sels.size()) ,
                                           AV58Conveniowwds_1_tfconvecodigo ,
                                           Integer.valueOf(AV61Conveniowwds_4_tfconvedescri_sels.size()) ,
                                           AV60Conveniowwds_3_tfconvedescri ,
                                           Integer.valueOf(AV63Conveniowwds_6_tfconvesindesc_sels.size()) ,
                                           AV62Conveniowwds_5_tfconvesindesc ,
                                           Short.valueOf(AV64Conveniowwds_7_tfconveescfrecact) ,
                                           Short.valueOf(AV65Conveniowwds_8_tfconveescfrecact_to) ,
                                           Short.valueOf(AV50PaiCod) ,
                                           Short.valueOf(A2131ConveEscFrecAct) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV58Conveniowwds_1_tfconvecodigo = GXutil.padr( GXutil.rtrim( AV58Conveniowwds_1_tfconvecodigo), 20, "%") ;
      lV60Conveniowwds_3_tfconvedescri = GXutil.concat( GXutil.rtrim( AV60Conveniowwds_3_tfconvedescri), "%", "") ;
      lV62Conveniowwds_5_tfconvesindesc = GXutil.concat( GXutil.rtrim( AV62Conveniowwds_5_tfconvesindesc), "%", "") ;
      /* Using cursor P006I2 */
      pr_default.execute(0, new Object[] {lV58Conveniowwds_1_tfconvecodigo, lV60Conveniowwds_3_tfconvedescri, lV62Conveniowwds_5_tfconvesindesc, Short.valueOf(AV64Conveniowwds_7_tfconveescfrecact), Short.valueOf(AV65Conveniowwds_8_tfconveescfrecact_to), Short.valueOf(AV50PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6I2 = false ;
         A935ConveSinCod = P006I2_A935ConveSinCod[0] ;
         n935ConveSinCod = P006I2_n935ConveSinCod[0] ;
         A9ConveCodigo = P006I2_A9ConveCodigo[0] ;
         A46PaiCod = P006I2_A46PaiCod[0] ;
         A2131ConveEscFrecAct = P006I2_A2131ConveEscFrecAct[0] ;
         A936ConveSinDesc = P006I2_A936ConveSinDesc[0] ;
         A160ConveDescri = P006I2_A160ConveDescri[0] ;
         A936ConveSinDesc = P006I2_A936ConveSinDesc[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P006I2_A9ConveCodigo[0], A9ConveCodigo) == 0 ) )
         {
            brk6I2 = false ;
            A46PaiCod = P006I2_A46PaiCod[0] ;
            AV30count = (long)(AV30count+1) ;
            brk6I2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A9ConveCodigo)==0) )
         {
            AV22Option = A9ConveCodigo ;
            AV23Options.add(AV22Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6I2 )
         {
            brk6I2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONVEDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV15TFConveDescri = AV18SearchTxt ;
      AV16TFConveDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Conveniowwds_1_tfconvecodigo = AV12TFConveCodigo ;
      AV59Conveniowwds_2_tfconvecodigo_sels = AV13TFConveCodigo_Sels ;
      AV60Conveniowwds_3_tfconvedescri = AV15TFConveDescri ;
      AV61Conveniowwds_4_tfconvedescri_sels = AV16TFConveDescri_Sels ;
      AV62Conveniowwds_5_tfconvesindesc = AV47TFConveSinDesc ;
      AV63Conveniowwds_6_tfconvesindesc_sels = AV48TFConveSinDesc_Sels ;
      AV64Conveniowwds_7_tfconveescfrecact = AV52TFConveEscFrecAct ;
      AV65Conveniowwds_8_tfconveescfrecact_to = AV53TFConveEscFrecAct_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A9ConveCodigo ,
                                           AV59Conveniowwds_2_tfconvecodigo_sels ,
                                           A160ConveDescri ,
                                           AV61Conveniowwds_4_tfconvedescri_sels ,
                                           A936ConveSinDesc ,
                                           AV63Conveniowwds_6_tfconvesindesc_sels ,
                                           Integer.valueOf(AV59Conveniowwds_2_tfconvecodigo_sels.size()) ,
                                           AV58Conveniowwds_1_tfconvecodigo ,
                                           Integer.valueOf(AV61Conveniowwds_4_tfconvedescri_sels.size()) ,
                                           AV60Conveniowwds_3_tfconvedescri ,
                                           Integer.valueOf(AV63Conveniowwds_6_tfconvesindesc_sels.size()) ,
                                           AV62Conveniowwds_5_tfconvesindesc ,
                                           Short.valueOf(AV64Conveniowwds_7_tfconveescfrecact) ,
                                           Short.valueOf(AV65Conveniowwds_8_tfconveescfrecact_to) ,
                                           Short.valueOf(AV50PaiCod) ,
                                           Short.valueOf(A2131ConveEscFrecAct) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV58Conveniowwds_1_tfconvecodigo = GXutil.padr( GXutil.rtrim( AV58Conveniowwds_1_tfconvecodigo), 20, "%") ;
      lV60Conveniowwds_3_tfconvedescri = GXutil.concat( GXutil.rtrim( AV60Conveniowwds_3_tfconvedescri), "%", "") ;
      lV62Conveniowwds_5_tfconvesindesc = GXutil.concat( GXutil.rtrim( AV62Conveniowwds_5_tfconvesindesc), "%", "") ;
      /* Using cursor P006I3 */
      pr_default.execute(1, new Object[] {lV58Conveniowwds_1_tfconvecodigo, lV60Conveniowwds_3_tfconvedescri, lV62Conveniowwds_5_tfconvesindesc, Short.valueOf(AV64Conveniowwds_7_tfconveescfrecact), Short.valueOf(AV65Conveniowwds_8_tfconveescfrecact_to), Short.valueOf(AV50PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6I4 = false ;
         A935ConveSinCod = P006I3_A935ConveSinCod[0] ;
         n935ConveSinCod = P006I3_n935ConveSinCod[0] ;
         A160ConveDescri = P006I3_A160ConveDescri[0] ;
         A46PaiCod = P006I3_A46PaiCod[0] ;
         A2131ConveEscFrecAct = P006I3_A2131ConveEscFrecAct[0] ;
         A936ConveSinDesc = P006I3_A936ConveSinDesc[0] ;
         A9ConveCodigo = P006I3_A9ConveCodigo[0] ;
         A936ConveSinDesc = P006I3_A936ConveSinDesc[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P006I3_A160ConveDescri[0], A160ConveDescri) == 0 ) )
         {
            brk6I4 = false ;
            A46PaiCod = P006I3_A46PaiCod[0] ;
            A9ConveCodigo = P006I3_A9ConveCodigo[0] ;
            AV30count = (long)(AV30count+1) ;
            brk6I4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A160ConveDescri)==0) )
         {
            AV22Option = A160ConveDescri ;
            AV23Options.add(AV22Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6I4 )
         {
            brk6I4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONVESINDESCOPTIONS' Routine */
      returnInSub = false ;
      AV47TFConveSinDesc = AV18SearchTxt ;
      AV48TFConveSinDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Conveniowwds_1_tfconvecodigo = AV12TFConveCodigo ;
      AV59Conveniowwds_2_tfconvecodigo_sels = AV13TFConveCodigo_Sels ;
      AV60Conveniowwds_3_tfconvedescri = AV15TFConveDescri ;
      AV61Conveniowwds_4_tfconvedescri_sels = AV16TFConveDescri_Sels ;
      AV62Conveniowwds_5_tfconvesindesc = AV47TFConveSinDesc ;
      AV63Conveniowwds_6_tfconvesindesc_sels = AV48TFConveSinDesc_Sels ;
      AV64Conveniowwds_7_tfconveescfrecact = AV52TFConveEscFrecAct ;
      AV65Conveniowwds_8_tfconveescfrecact_to = AV53TFConveEscFrecAct_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A9ConveCodigo ,
                                           AV59Conveniowwds_2_tfconvecodigo_sels ,
                                           A160ConveDescri ,
                                           AV61Conveniowwds_4_tfconvedescri_sels ,
                                           A936ConveSinDesc ,
                                           AV63Conveniowwds_6_tfconvesindesc_sels ,
                                           Integer.valueOf(AV59Conveniowwds_2_tfconvecodigo_sels.size()) ,
                                           AV58Conveniowwds_1_tfconvecodigo ,
                                           Integer.valueOf(AV61Conveniowwds_4_tfconvedescri_sels.size()) ,
                                           AV60Conveniowwds_3_tfconvedescri ,
                                           Integer.valueOf(AV63Conveniowwds_6_tfconvesindesc_sels.size()) ,
                                           AV62Conveniowwds_5_tfconvesindesc ,
                                           Short.valueOf(AV64Conveniowwds_7_tfconveescfrecact) ,
                                           Short.valueOf(AV65Conveniowwds_8_tfconveescfrecact_to) ,
                                           Short.valueOf(AV50PaiCod) ,
                                           Short.valueOf(A2131ConveEscFrecAct) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV58Conveniowwds_1_tfconvecodigo = GXutil.padr( GXutil.rtrim( AV58Conveniowwds_1_tfconvecodigo), 20, "%") ;
      lV60Conveniowwds_3_tfconvedescri = GXutil.concat( GXutil.rtrim( AV60Conveniowwds_3_tfconvedescri), "%", "") ;
      lV62Conveniowwds_5_tfconvesindesc = GXutil.concat( GXutil.rtrim( AV62Conveniowwds_5_tfconvesindesc), "%", "") ;
      /* Using cursor P006I4 */
      pr_default.execute(2, new Object[] {lV58Conveniowwds_1_tfconvecodigo, lV60Conveniowwds_3_tfconvedescri, lV62Conveniowwds_5_tfconvesindesc, Short.valueOf(AV64Conveniowwds_7_tfconveescfrecact), Short.valueOf(AV65Conveniowwds_8_tfconveescfrecact_to), Short.valueOf(AV50PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6I6 = false ;
         A935ConveSinCod = P006I4_A935ConveSinCod[0] ;
         n935ConveSinCod = P006I4_n935ConveSinCod[0] ;
         A46PaiCod = P006I4_A46PaiCod[0] ;
         A2131ConveEscFrecAct = P006I4_A2131ConveEscFrecAct[0] ;
         A936ConveSinDesc = P006I4_A936ConveSinDesc[0] ;
         A160ConveDescri = P006I4_A160ConveDescri[0] ;
         A9ConveCodigo = P006I4_A9ConveCodigo[0] ;
         A936ConveSinDesc = P006I4_A936ConveSinDesc[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P006I4_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P006I4_A935ConveSinCod[0], A935ConveSinCod) == 0 ) )
         {
            brk6I6 = false ;
            A9ConveCodigo = P006I4_A9ConveCodigo[0] ;
            AV30count = (long)(AV30count+1) ;
            brk6I6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A936ConveSinDesc)==0) )
         {
            AV22Option = A936ConveSinDesc ;
            AV21InsertIndex = 1 ;
            while ( ( AV21InsertIndex <= AV23Options.size() ) && ( GXutil.strcmp((String)AV23Options.elementAt(-1+AV21InsertIndex), AV22Option) < 0 ) )
            {
               AV21InsertIndex = (int)(AV21InsertIndex+1) ;
            }
            AV23Options.add(AV22Option, AV21InsertIndex);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), AV21InsertIndex);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6I6 )
         {
            brk6I6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = conveniowwgetfilterdata.this.AV24OptionsJson;
      this.aP4[0] = conveniowwgetfilterdata.this.AV27OptionsDescJson;
      this.aP5[0] = conveniowwgetfilterdata.this.AV29OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24OptionsJson = "" ;
      AV27OptionsDescJson = "" ;
      AV29OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFConveCodigo = "" ;
      AV11TFConveCodigo_SelsJson = "" ;
      AV13TFConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFConveDescri = "" ;
      AV14TFConveDescri_SelsJson = "" ;
      AV16TFConveDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFConveSinDesc = "" ;
      AV46TFConveSinDesc_SelsJson = "" ;
      AV48TFConveSinDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51MenuOpcCod = "" ;
      A9ConveCodigo = "" ;
      AV58Conveniowwds_1_tfconvecodigo = "" ;
      AV59Conveniowwds_2_tfconvecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60Conveniowwds_3_tfconvedescri = "" ;
      AV61Conveniowwds_4_tfconvedescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Conveniowwds_5_tfconvesindesc = "" ;
      AV63Conveniowwds_6_tfconvesindesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV58Conveniowwds_1_tfconvecodigo = "" ;
      lV60Conveniowwds_3_tfconvedescri = "" ;
      lV62Conveniowwds_5_tfconvesindesc = "" ;
      A160ConveDescri = "" ;
      A936ConveSinDesc = "" ;
      P006I2_A935ConveSinCod = new String[] {""} ;
      P006I2_n935ConveSinCod = new boolean[] {false} ;
      P006I2_A9ConveCodigo = new String[] {""} ;
      P006I2_A46PaiCod = new short[1] ;
      P006I2_A2131ConveEscFrecAct = new short[1] ;
      P006I2_A936ConveSinDesc = new String[] {""} ;
      P006I2_A160ConveDescri = new String[] {""} ;
      A935ConveSinCod = "" ;
      AV22Option = "" ;
      P006I3_A935ConveSinCod = new String[] {""} ;
      P006I3_n935ConveSinCod = new boolean[] {false} ;
      P006I3_A160ConveDescri = new String[] {""} ;
      P006I3_A46PaiCod = new short[1] ;
      P006I3_A2131ConveEscFrecAct = new short[1] ;
      P006I3_A936ConveSinDesc = new String[] {""} ;
      P006I3_A9ConveCodigo = new String[] {""} ;
      P006I4_A935ConveSinCod = new String[] {""} ;
      P006I4_n935ConveSinCod = new boolean[] {false} ;
      P006I4_A46PaiCod = new short[1] ;
      P006I4_A2131ConveEscFrecAct = new short[1] ;
      P006I4_A936ConveSinDesc = new String[] {""} ;
      P006I4_A160ConveDescri = new String[] {""} ;
      P006I4_A9ConveCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006I2_A935ConveSinCod, P006I2_n935ConveSinCod, P006I2_A9ConveCodigo, P006I2_A46PaiCod, P006I2_A2131ConveEscFrecAct, P006I2_A936ConveSinDesc, P006I2_A160ConveDescri
            }
            , new Object[] {
            P006I3_A935ConveSinCod, P006I3_n935ConveSinCod, P006I3_A160ConveDescri, P006I3_A46PaiCod, P006I3_A2131ConveEscFrecAct, P006I3_A936ConveSinDesc, P006I3_A9ConveCodigo
            }
            , new Object[] {
            P006I4_A935ConveSinCod, P006I4_n935ConveSinCod, P006I4_A46PaiCod, P006I4_A2131ConveEscFrecAct, P006I4_A936ConveSinDesc, P006I4_A160ConveDescri, P006I4_A9ConveCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV52TFConveEscFrecAct ;
   private short AV53TFConveEscFrecAct_To ;
   private short AV64Conveniowwds_7_tfconveescfrecact ;
   private short AV65Conveniowwds_8_tfconveescfrecact_to ;
   private short AV50PaiCod ;
   private short A2131ConveEscFrecAct ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV43CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV56GXV1 ;
   private int AV59Conveniowwds_2_tfconvecodigo_sels_size ;
   private int AV61Conveniowwds_4_tfconvedescri_sels_size ;
   private int AV63Conveniowwds_6_tfconvesindesc_sels_size ;
   private int AV21InsertIndex ;
   private long AV30count ;
   private String AV12TFConveCodigo ;
   private String A9ConveCodigo ;
   private String AV58Conveniowwds_1_tfconvecodigo ;
   private String scmdbuf ;
   private String lV58Conveniowwds_1_tfconvecodigo ;
   private String A935ConveSinCod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk6I2 ;
   private boolean n935ConveSinCod ;
   private boolean brk6I4 ;
   private boolean brk6I6 ;
   private String AV24OptionsJson ;
   private String AV27OptionsDescJson ;
   private String AV29OptionIndexesJson ;
   private String AV11TFConveCodigo_SelsJson ;
   private String AV14TFConveDescri_SelsJson ;
   private String AV46TFConveSinDesc_SelsJson ;
   private String AV20DDOName ;
   private String AV18SearchTxt ;
   private String AV19SearchTxtTo ;
   private String AV15TFConveDescri ;
   private String AV47TFConveSinDesc ;
   private String AV51MenuOpcCod ;
   private String AV60Conveniowwds_3_tfconvedescri ;
   private String AV62Conveniowwds_5_tfconvesindesc ;
   private String lV60Conveniowwds_3_tfconvedescri ;
   private String lV62Conveniowwds_5_tfconvesindesc ;
   private String A160ConveDescri ;
   private String A936ConveSinDesc ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P006I2_A935ConveSinCod ;
   private boolean[] P006I2_n935ConveSinCod ;
   private String[] P006I2_A9ConveCodigo ;
   private short[] P006I2_A46PaiCod ;
   private short[] P006I2_A2131ConveEscFrecAct ;
   private String[] P006I2_A936ConveSinDesc ;
   private String[] P006I2_A160ConveDescri ;
   private String[] P006I3_A935ConveSinCod ;
   private boolean[] P006I3_n935ConveSinCod ;
   private String[] P006I3_A160ConveDescri ;
   private short[] P006I3_A46PaiCod ;
   private short[] P006I3_A2131ConveEscFrecAct ;
   private String[] P006I3_A936ConveSinDesc ;
   private String[] P006I3_A9ConveCodigo ;
   private String[] P006I4_A935ConveSinCod ;
   private boolean[] P006I4_n935ConveSinCod ;
   private short[] P006I4_A46PaiCod ;
   private short[] P006I4_A2131ConveEscFrecAct ;
   private String[] P006I4_A936ConveSinDesc ;
   private String[] P006I4_A160ConveDescri ;
   private String[] P006I4_A9ConveCodigo ;
   private GXSimpleCollection<String> AV13TFConveCodigo_Sels ;
   private GXSimpleCollection<String> AV59Conveniowwds_2_tfconvecodigo_sels ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV16TFConveDescri_Sels ;
   private GXSimpleCollection<String> AV48TFConveSinDesc_Sels ;
   private GXSimpleCollection<String> AV61Conveniowwds_4_tfconvedescri_sels ;
   private GXSimpleCollection<String> AV63Conveniowwds_6_tfconvesindesc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class conveniowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A9ConveCodigo ,
                                          GXSimpleCollection<String> AV59Conveniowwds_2_tfconvecodigo_sels ,
                                          String A160ConveDescri ,
                                          GXSimpleCollection<String> AV61Conveniowwds_4_tfconvedescri_sels ,
                                          String A936ConveSinDesc ,
                                          GXSimpleCollection<String> AV63Conveniowwds_6_tfconvesindesc_sels ,
                                          int AV59Conveniowwds_2_tfconvecodigo_sels_size ,
                                          String AV58Conveniowwds_1_tfconvecodigo ,
                                          int AV61Conveniowwds_4_tfconvedescri_sels_size ,
                                          String AV60Conveniowwds_3_tfconvedescri ,
                                          int AV63Conveniowwds_6_tfconvesindesc_sels_size ,
                                          String AV62Conveniowwds_5_tfconvesindesc ,
                                          short AV64Conveniowwds_7_tfconveescfrecact ,
                                          short AV65Conveniowwds_8_tfconveescfrecact_to ,
                                          short AV50PaiCod ,
                                          short A2131ConveEscFrecAct ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.ConveSinCod AS ConveSinCod, T1.ConveCodigo, T1.PaiCod, T1.ConveEscFrecAct, T2.SinDescrip AS ConveSinDesc, T1.ConveDescri FROM (Convenio T1 LEFT JOIN Sindicato" ;
      scmdbuf += " T2 ON T2.PaiCod = T1.PaiCod AND T2.SinCod = T1.ConveSinCod)" ;
      if ( ( AV59Conveniowwds_2_tfconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Conveniowwds_1_tfconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV59Conveniowwds_2_tfconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Conveniowwds_2_tfconvecodigo_sels, "T1.ConveCodigo IN (", ")")+")");
      }
      if ( ( AV61Conveniowwds_4_tfconvedescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Conveniowwds_3_tfconvedescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV61Conveniowwds_4_tfconvedescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Conveniowwds_4_tfconvedescri_sels, "T1.ConveDescri IN (", ")")+")");
      }
      if ( ( AV63Conveniowwds_6_tfconvesindesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Conveniowwds_5_tfconvesindesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SinDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV63Conveniowwds_6_tfconvesindesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Conveniowwds_6_tfconvesindesc_sels, "T2.SinDescrip IN (", ")")+")");
      }
      if ( ! (0==AV64Conveniowwds_7_tfconveescfrecact) )
      {
         addWhere(sWhereString, "(T1.ConveEscFrecAct >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV65Conveniowwds_8_tfconveescfrecact_to) )
      {
         addWhere(sWhereString, "(T1.ConveEscFrecAct <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV50PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConveCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006I3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A9ConveCodigo ,
                                          GXSimpleCollection<String> AV59Conveniowwds_2_tfconvecodigo_sels ,
                                          String A160ConveDescri ,
                                          GXSimpleCollection<String> AV61Conveniowwds_4_tfconvedescri_sels ,
                                          String A936ConveSinDesc ,
                                          GXSimpleCollection<String> AV63Conveniowwds_6_tfconvesindesc_sels ,
                                          int AV59Conveniowwds_2_tfconvecodigo_sels_size ,
                                          String AV58Conveniowwds_1_tfconvecodigo ,
                                          int AV61Conveniowwds_4_tfconvedescri_sels_size ,
                                          String AV60Conveniowwds_3_tfconvedescri ,
                                          int AV63Conveniowwds_6_tfconvesindesc_sels_size ,
                                          String AV62Conveniowwds_5_tfconvesindesc ,
                                          short AV64Conveniowwds_7_tfconveescfrecact ,
                                          short AV65Conveniowwds_8_tfconveescfrecact_to ,
                                          short AV50PaiCod ,
                                          short A2131ConveEscFrecAct ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.ConveSinCod AS ConveSinCod, T1.ConveDescri, T1.PaiCod, T1.ConveEscFrecAct, T2.SinDescrip AS ConveSinDesc, T1.ConveCodigo FROM (Convenio T1 LEFT JOIN Sindicato" ;
      scmdbuf += " T2 ON T2.PaiCod = T1.PaiCod AND T2.SinCod = T1.ConveSinCod)" ;
      if ( ( AV59Conveniowwds_2_tfconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Conveniowwds_1_tfconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV59Conveniowwds_2_tfconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Conveniowwds_2_tfconvecodigo_sels, "T1.ConveCodigo IN (", ")")+")");
      }
      if ( ( AV61Conveniowwds_4_tfconvedescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Conveniowwds_3_tfconvedescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV61Conveniowwds_4_tfconvedescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Conveniowwds_4_tfconvedescri_sels, "T1.ConveDescri IN (", ")")+")");
      }
      if ( ( AV63Conveniowwds_6_tfconvesindesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Conveniowwds_5_tfconvesindesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SinDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV63Conveniowwds_6_tfconvesindesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Conveniowwds_6_tfconvesindesc_sels, "T2.SinDescrip IN (", ")")+")");
      }
      if ( ! (0==AV64Conveniowwds_7_tfconveescfrecact) )
      {
         addWhere(sWhereString, "(T1.ConveEscFrecAct >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV65Conveniowwds_8_tfconveescfrecact_to) )
      {
         addWhere(sWhereString, "(T1.ConveEscFrecAct <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV50PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConveDescri" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006I4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A9ConveCodigo ,
                                          GXSimpleCollection<String> AV59Conveniowwds_2_tfconvecodigo_sels ,
                                          String A160ConveDescri ,
                                          GXSimpleCollection<String> AV61Conveniowwds_4_tfconvedescri_sels ,
                                          String A936ConveSinDesc ,
                                          GXSimpleCollection<String> AV63Conveniowwds_6_tfconvesindesc_sels ,
                                          int AV59Conveniowwds_2_tfconvecodigo_sels_size ,
                                          String AV58Conveniowwds_1_tfconvecodigo ,
                                          int AV61Conveniowwds_4_tfconvedescri_sels_size ,
                                          String AV60Conveniowwds_3_tfconvedescri ,
                                          int AV63Conveniowwds_6_tfconvesindesc_sels_size ,
                                          String AV62Conveniowwds_5_tfconvesindesc ,
                                          short AV64Conveniowwds_7_tfconveescfrecact ,
                                          short AV65Conveniowwds_8_tfconveescfrecact_to ,
                                          short AV50PaiCod ,
                                          short A2131ConveEscFrecAct ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.ConveSinCod AS ConveSinCod, T1.PaiCod, T1.ConveEscFrecAct, T2.SinDescrip AS ConveSinDesc, T1.ConveDescri, T1.ConveCodigo FROM (Convenio T1 LEFT JOIN Sindicato" ;
      scmdbuf += " T2 ON T2.PaiCod = T1.PaiCod AND T2.SinCod = T1.ConveSinCod)" ;
      if ( ( AV59Conveniowwds_2_tfconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Conveniowwds_1_tfconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV59Conveniowwds_2_tfconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Conveniowwds_2_tfconvecodigo_sels, "T1.ConveCodigo IN (", ")")+")");
      }
      if ( ( AV61Conveniowwds_4_tfconvedescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Conveniowwds_3_tfconvedescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV61Conveniowwds_4_tfconvedescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Conveniowwds_4_tfconvedescri_sels, "T1.ConveDescri IN (", ")")+")");
      }
      if ( ( AV63Conveniowwds_6_tfconvesindesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Conveniowwds_5_tfconvesindesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SinDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV63Conveniowwds_6_tfconvesindesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Conveniowwds_6_tfconvesindesc_sels, "T2.SinDescrip IN (", ")")+")");
      }
      if ( ! (0==AV64Conveniowwds_7_tfconveescfrecact) )
      {
         addWhere(sWhereString, "(T1.ConveEscFrecAct >= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! (0==AV65Conveniowwds_8_tfconveescfrecact_to) )
      {
         addWhere(sWhereString, "(T1.ConveEscFrecAct <= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (0==AV50PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.PaiCod, T1.ConveSinCod" ;
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
                  return conditional_P006I2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() );
            case 1 :
                  return conditional_P006I3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() );
            case 2 :
                  return conditional_P006I4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006I2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006I3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006I4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
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
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
      }
   }

}


package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class feriado_agendawwgetfilterdata extends GXProcedure
{
   public feriado_agendawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriado_agendawwgetfilterdata.class ), "" );
   }

   public feriado_agendawwgetfilterdata( int remoteHandle ,
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
      feriado_agendawwgetfilterdata.this.aP5 = new String[] {""};
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
      feriado_agendawwgetfilterdata.this.AV46DDOName = aP0;
      feriado_agendawwgetfilterdata.this.AV47SearchTxt = aP1;
      feriado_agendawwgetfilterdata.this.AV48SearchTxtTo = aP2;
      feriado_agendawwgetfilterdata.this.aP3 = aP3;
      feriado_agendawwgetfilterdata.this.aP4 = aP4;
      feriado_agendawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV53EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      feriado_agendawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV53EmpCod = GXt_int1 ;
      GXt_int3 = AV54CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      feriado_agendawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV54CliCod = GXt_int3 ;
      AV36Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV38OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_agenda", GXv_boolean6) ;
      feriado_agendawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV46DDOName), "DDO_FERID") == 0 )
         {
            /* Execute user subroutine: 'LOADFERIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV46DDOName), "DDO_FERDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADFERDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV46DDOName), "DDO_FERIADOCONVENIO") == 0 )
         {
            /* Execute user subroutine: 'LOADFERIADOCONVENIOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV49OptionsJson = AV36Options.toJSonString(false) ;
      AV50OptionsDescJson = AV38OptionsDesc.toJSonString(false) ;
      AV51OptionIndexesJson = AV39OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV41Session.getValue("feriado_agendaWWGridState"), "") == 0 )
      {
         AV43GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "feriado_agendaWWGridState"), null, null);
      }
      else
      {
         AV43GridState.fromxml(AV41Session.getValue("feriado_agendaWWGridState"), null, null);
      }
      AV80GXV1 = 1 ;
      while ( AV80GXV1 <= AV43GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV44GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV43GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV1));
         if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID") == 0 )
         {
            AV14TFFerId = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID_SEL") == 0 )
         {
            AV13TFFerId_SelsJson = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFFerId_Sels.fromJSonString(AV13TFFerId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP") == 0 )
         {
            AV21TFFerDescrip = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP_SEL") == 0 )
         {
            AV20TFFerDescrip_SelsJson = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFFerDescrip_Sels.fromJSonString(AV20TFFerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERANIO") == 0 )
         {
            AV16TFFerAnio = (short)(GXutil.lval( AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV17TFFerAnio_To = (short)(GXutil.lval( AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERFECHA") == 0 )
         {
            AV18TFFerFecha = localUtil.ctod( AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV19TFFerFecha_To = localUtil.ctod( AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOTIPO_SEL") == 0 )
         {
            AV55TFFeriadoTipo_SelsJson = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFFeriadoTipo_Sels.fromJSonString(AV55TFFeriadoTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO") == 0 )
         {
            AV32TFFeriadoConvenio = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO_SEL") == 0 )
         {
            AV31TFFeriadoConvenio_SelsJson = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV33TFFeriadoConvenio_Sels.fromJSonString(AV31TFFeriadoConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV77MenuOpcCod = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV80GXV1 = (int)(AV80GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADFERIDOPTIONS' Routine */
      returnInSub = false ;
      AV14TFFerId = AV47SearchTxt ;
      AV15TFFerId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV82Feriado_agendawwds_1_tfferid = AV14TFFerId ;
      AV83Feriado_agendawwds_2_tfferid_sels = AV15TFFerId_Sels ;
      AV84Feriado_agendawwds_3_tfferdescrip = AV21TFFerDescrip ;
      AV85Feriado_agendawwds_4_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV86Feriado_agendawwds_5_tfferanio = AV16TFFerAnio ;
      AV87Feriado_agendawwds_6_tfferanio_to = AV17TFFerAnio_To ;
      AV88Feriado_agendawwds_7_tfferfecha = AV18TFFerFecha ;
      AV89Feriado_agendawwds_8_tfferfecha_to = AV19TFFerFecha_To ;
      AV90Feriado_agendawwds_9_tfferiadotipo_sels = AV56TFFeriadoTipo_Sels ;
      AV91Feriado_agendawwds_10_tfferiadoconvenio = AV32TFFeriadoConvenio ;
      AV92Feriado_agendawwds_11_tfferiadoconvenio_sels = AV33TFFeriadoConvenio_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV83Feriado_agendawwds_2_tfferid_sels ,
                                           A1228FerDescrip ,
                                           AV85Feriado_agendawwds_4_tfferdescrip_sels ,
                                           A1233FeriadoTipo ,
                                           AV90Feriado_agendawwds_9_tfferiadotipo_sels ,
                                           A1234FeriadoConvenio ,
                                           AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV83Feriado_agendawwds_2_tfferid_sels.size()) ,
                                           AV82Feriado_agendawwds_1_tfferid ,
                                           Integer.valueOf(AV85Feriado_agendawwds_4_tfferdescrip_sels.size()) ,
                                           AV84Feriado_agendawwds_3_tfferdescrip ,
                                           Short.valueOf(AV86Feriado_agendawwds_5_tfferanio) ,
                                           Short.valueOf(AV87Feriado_agendawwds_6_tfferanio_to) ,
                                           AV88Feriado_agendawwds_7_tfferfecha ,
                                           AV89Feriado_agendawwds_8_tfferfecha_to ,
                                           Integer.valueOf(AV90Feriado_agendawwds_9_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV92Feriado_agendawwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV91Feriado_agendawwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV70PaiCod) ,
                                           Short.valueOf(A1226FerAnio) ,
                                           A1227FerFecha ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.SHORT
                                           }
      });
      lV82Feriado_agendawwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV82Feriado_agendawwds_1_tfferid), 40, "%") ;
      lV84Feriado_agendawwds_3_tfferdescrip = GXutil.concat( GXutil.rtrim( AV84Feriado_agendawwds_3_tfferdescrip), "%", "") ;
      lV91Feriado_agendawwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV91Feriado_agendawwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01BD2 */
      pr_default.execute(0, new Object[] {lV82Feriado_agendawwds_1_tfferid, lV84Feriado_agendawwds_3_tfferdescrip, Short.valueOf(AV86Feriado_agendawwds_5_tfferanio), Short.valueOf(AV87Feriado_agendawwds_6_tfferanio_to), AV88Feriado_agendawwds_7_tfferfecha, AV89Feriado_agendawwds_8_tfferfecha_to, lV91Feriado_agendawwds_10_tfferiadoconvenio, Short.valueOf(AV70PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1BD2 = false ;
         A1223FerId = P01BD2_A1223FerId[0] ;
         A46PaiCod = P01BD2_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01BD2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BD2_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01BD2_A1233FeriadoTipo[0] ;
         A1227FerFecha = P01BD2_A1227FerFecha[0] ;
         A1226FerAnio = P01BD2_A1226FerAnio[0] ;
         A1228FerDescrip = P01BD2_A1228FerDescrip[0] ;
         A1234FeriadoConvenio = P01BD2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BD2_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01BD2_A1233FeriadoTipo[0] ;
         A1228FerDescrip = P01BD2_A1228FerDescrip[0] ;
         AV40count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01BD2_A1223FerId[0], A1223FerId) == 0 ) )
         {
            brk1BD2 = false ;
            A46PaiCod = P01BD2_A46PaiCod[0] ;
            A1227FerFecha = P01BD2_A1227FerFecha[0] ;
            A1226FerAnio = P01BD2_A1226FerAnio[0] ;
            AV40count = (long)(AV40count+1) ;
            brk1BD2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1223FerId)==0) )
         {
            AV35Option = A1223FerId ;
            AV36Options.add(AV35Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV40count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1BD2 )
         {
            brk1BD2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADFERDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV21TFFerDescrip = AV47SearchTxt ;
      AV22TFFerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV82Feriado_agendawwds_1_tfferid = AV14TFFerId ;
      AV83Feriado_agendawwds_2_tfferid_sels = AV15TFFerId_Sels ;
      AV84Feriado_agendawwds_3_tfferdescrip = AV21TFFerDescrip ;
      AV85Feriado_agendawwds_4_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV86Feriado_agendawwds_5_tfferanio = AV16TFFerAnio ;
      AV87Feriado_agendawwds_6_tfferanio_to = AV17TFFerAnio_To ;
      AV88Feriado_agendawwds_7_tfferfecha = AV18TFFerFecha ;
      AV89Feriado_agendawwds_8_tfferfecha_to = AV19TFFerFecha_To ;
      AV90Feriado_agendawwds_9_tfferiadotipo_sels = AV56TFFeriadoTipo_Sels ;
      AV91Feriado_agendawwds_10_tfferiadoconvenio = AV32TFFeriadoConvenio ;
      AV92Feriado_agendawwds_11_tfferiadoconvenio_sels = AV33TFFeriadoConvenio_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV83Feriado_agendawwds_2_tfferid_sels ,
                                           A1228FerDescrip ,
                                           AV85Feriado_agendawwds_4_tfferdescrip_sels ,
                                           A1233FeriadoTipo ,
                                           AV90Feriado_agendawwds_9_tfferiadotipo_sels ,
                                           A1234FeriadoConvenio ,
                                           AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV83Feriado_agendawwds_2_tfferid_sels.size()) ,
                                           AV82Feriado_agendawwds_1_tfferid ,
                                           Integer.valueOf(AV85Feriado_agendawwds_4_tfferdescrip_sels.size()) ,
                                           AV84Feriado_agendawwds_3_tfferdescrip ,
                                           Short.valueOf(AV86Feriado_agendawwds_5_tfferanio) ,
                                           Short.valueOf(AV87Feriado_agendawwds_6_tfferanio_to) ,
                                           AV88Feriado_agendawwds_7_tfferfecha ,
                                           AV89Feriado_agendawwds_8_tfferfecha_to ,
                                           Integer.valueOf(AV90Feriado_agendawwds_9_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV92Feriado_agendawwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV91Feriado_agendawwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV70PaiCod) ,
                                           Short.valueOf(A1226FerAnio) ,
                                           A1227FerFecha ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.SHORT
                                           }
      });
      lV82Feriado_agendawwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV82Feriado_agendawwds_1_tfferid), 40, "%") ;
      lV84Feriado_agendawwds_3_tfferdescrip = GXutil.concat( GXutil.rtrim( AV84Feriado_agendawwds_3_tfferdescrip), "%", "") ;
      lV91Feriado_agendawwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV91Feriado_agendawwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01BD3 */
      pr_default.execute(1, new Object[] {lV82Feriado_agendawwds_1_tfferid, lV84Feriado_agendawwds_3_tfferdescrip, Short.valueOf(AV86Feriado_agendawwds_5_tfferanio), Short.valueOf(AV87Feriado_agendawwds_6_tfferanio_to), AV88Feriado_agendawwds_7_tfferfecha, AV89Feriado_agendawwds_8_tfferfecha_to, lV91Feriado_agendawwds_10_tfferiadoconvenio, Short.valueOf(AV70PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1BD4 = false ;
         A1228FerDescrip = P01BD3_A1228FerDescrip[0] ;
         A46PaiCod = P01BD3_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01BD3_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BD3_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01BD3_A1233FeriadoTipo[0] ;
         A1227FerFecha = P01BD3_A1227FerFecha[0] ;
         A1226FerAnio = P01BD3_A1226FerAnio[0] ;
         A1223FerId = P01BD3_A1223FerId[0] ;
         A1228FerDescrip = P01BD3_A1228FerDescrip[0] ;
         A1234FeriadoConvenio = P01BD3_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BD3_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01BD3_A1233FeriadoTipo[0] ;
         AV40count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01BD3_A1228FerDescrip[0], A1228FerDescrip) == 0 ) )
         {
            brk1BD4 = false ;
            A46PaiCod = P01BD3_A46PaiCod[0] ;
            A1227FerFecha = P01BD3_A1227FerFecha[0] ;
            A1226FerAnio = P01BD3_A1226FerAnio[0] ;
            A1223FerId = P01BD3_A1223FerId[0] ;
            AV40count = (long)(AV40count+1) ;
            brk1BD4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1228FerDescrip)==0) )
         {
            AV35Option = A1228FerDescrip ;
            AV36Options.add(AV35Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV40count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1BD4 )
         {
            brk1BD4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADFERIADOCONVENIOOPTIONS' Routine */
      returnInSub = false ;
      AV32TFFeriadoConvenio = AV47SearchTxt ;
      AV33TFFeriadoConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV82Feriado_agendawwds_1_tfferid = AV14TFFerId ;
      AV83Feriado_agendawwds_2_tfferid_sels = AV15TFFerId_Sels ;
      AV84Feriado_agendawwds_3_tfferdescrip = AV21TFFerDescrip ;
      AV85Feriado_agendawwds_4_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV86Feriado_agendawwds_5_tfferanio = AV16TFFerAnio ;
      AV87Feriado_agendawwds_6_tfferanio_to = AV17TFFerAnio_To ;
      AV88Feriado_agendawwds_7_tfferfecha = AV18TFFerFecha ;
      AV89Feriado_agendawwds_8_tfferfecha_to = AV19TFFerFecha_To ;
      AV90Feriado_agendawwds_9_tfferiadotipo_sels = AV56TFFeriadoTipo_Sels ;
      AV91Feriado_agendawwds_10_tfferiadoconvenio = AV32TFFeriadoConvenio ;
      AV92Feriado_agendawwds_11_tfferiadoconvenio_sels = AV33TFFeriadoConvenio_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV83Feriado_agendawwds_2_tfferid_sels ,
                                           A1228FerDescrip ,
                                           AV85Feriado_agendawwds_4_tfferdescrip_sels ,
                                           A1233FeriadoTipo ,
                                           AV90Feriado_agendawwds_9_tfferiadotipo_sels ,
                                           A1234FeriadoConvenio ,
                                           AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV83Feriado_agendawwds_2_tfferid_sels.size()) ,
                                           AV82Feriado_agendawwds_1_tfferid ,
                                           Integer.valueOf(AV85Feriado_agendawwds_4_tfferdescrip_sels.size()) ,
                                           AV84Feriado_agendawwds_3_tfferdescrip ,
                                           Short.valueOf(AV86Feriado_agendawwds_5_tfferanio) ,
                                           Short.valueOf(AV87Feriado_agendawwds_6_tfferanio_to) ,
                                           AV88Feriado_agendawwds_7_tfferfecha ,
                                           AV89Feriado_agendawwds_8_tfferfecha_to ,
                                           Integer.valueOf(AV90Feriado_agendawwds_9_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV92Feriado_agendawwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV91Feriado_agendawwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV70PaiCod) ,
                                           Short.valueOf(A1226FerAnio) ,
                                           A1227FerFecha ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.SHORT
                                           }
      });
      lV82Feriado_agendawwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV82Feriado_agendawwds_1_tfferid), 40, "%") ;
      lV84Feriado_agendawwds_3_tfferdescrip = GXutil.concat( GXutil.rtrim( AV84Feriado_agendawwds_3_tfferdescrip), "%", "") ;
      lV91Feriado_agendawwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV91Feriado_agendawwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01BD4 */
      pr_default.execute(2, new Object[] {lV82Feriado_agendawwds_1_tfferid, lV84Feriado_agendawwds_3_tfferdescrip, Short.valueOf(AV86Feriado_agendawwds_5_tfferanio), Short.valueOf(AV87Feriado_agendawwds_6_tfferanio_to), AV88Feriado_agendawwds_7_tfferfecha, AV89Feriado_agendawwds_8_tfferfecha_to, lV91Feriado_agendawwds_10_tfferiadoconvenio, Short.valueOf(AV70PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1BD6 = false ;
         A1234FeriadoConvenio = P01BD4_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BD4_n1234FeriadoConvenio[0] ;
         A46PaiCod = P01BD4_A46PaiCod[0] ;
         A1233FeriadoTipo = P01BD4_A1233FeriadoTipo[0] ;
         A1227FerFecha = P01BD4_A1227FerFecha[0] ;
         A1226FerAnio = P01BD4_A1226FerAnio[0] ;
         A1228FerDescrip = P01BD4_A1228FerDescrip[0] ;
         A1223FerId = P01BD4_A1223FerId[0] ;
         A1234FeriadoConvenio = P01BD4_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BD4_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01BD4_A1233FeriadoTipo[0] ;
         A1228FerDescrip = P01BD4_A1228FerDescrip[0] ;
         AV40count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01BD4_A1234FeriadoConvenio[0], A1234FeriadoConvenio) == 0 ) )
         {
            brk1BD6 = false ;
            A46PaiCod = P01BD4_A46PaiCod[0] ;
            A1227FerFecha = P01BD4_A1227FerFecha[0] ;
            A1226FerAnio = P01BD4_A1226FerAnio[0] ;
            A1223FerId = P01BD4_A1223FerId[0] ;
            AV40count = (long)(AV40count+1) ;
            brk1BD6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1234FeriadoConvenio)==0) )
         {
            AV35Option = A1234FeriadoConvenio ;
            AV36Options.add(AV35Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV40count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1BD6 )
         {
            brk1BD6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = feriado_agendawwgetfilterdata.this.AV49OptionsJson;
      this.aP4[0] = feriado_agendawwgetfilterdata.this.AV50OptionsDescJson;
      this.aP5[0] = feriado_agendawwgetfilterdata.this.AV51OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV49OptionsJson = "" ;
      AV50OptionsDescJson = "" ;
      AV51OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV36Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV41Session = httpContext.getWebSession();
      AV43GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV44GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFFerId = "" ;
      AV13TFFerId_SelsJson = "" ;
      AV15TFFerId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFFerDescrip = "" ;
      AV20TFFerDescrip_SelsJson = "" ;
      AV22TFFerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFFerFecha = GXutil.nullDate() ;
      AV19TFFerFecha_To = GXutil.nullDate() ;
      AV55TFFeriadoTipo_SelsJson = "" ;
      AV56TFFeriadoTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32TFFeriadoConvenio = "" ;
      AV31TFFeriadoConvenio_SelsJson = "" ;
      AV33TFFeriadoConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77MenuOpcCod = "" ;
      A1223FerId = "" ;
      AV82Feriado_agendawwds_1_tfferid = "" ;
      AV83Feriado_agendawwds_2_tfferid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84Feriado_agendawwds_3_tfferdescrip = "" ;
      AV85Feriado_agendawwds_4_tfferdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88Feriado_agendawwds_7_tfferfecha = GXutil.nullDate() ;
      AV89Feriado_agendawwds_8_tfferfecha_to = GXutil.nullDate() ;
      AV90Feriado_agendawwds_9_tfferiadotipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91Feriado_agendawwds_10_tfferiadoconvenio = "" ;
      AV92Feriado_agendawwds_11_tfferiadoconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV82Feriado_agendawwds_1_tfferid = "" ;
      lV84Feriado_agendawwds_3_tfferdescrip = "" ;
      lV91Feriado_agendawwds_10_tfferiadoconvenio = "" ;
      A1228FerDescrip = "" ;
      A1233FeriadoTipo = "" ;
      A1234FeriadoConvenio = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      P01BD2_A1223FerId = new String[] {""} ;
      P01BD2_A46PaiCod = new short[1] ;
      P01BD2_A1234FeriadoConvenio = new String[] {""} ;
      P01BD2_n1234FeriadoConvenio = new boolean[] {false} ;
      P01BD2_A1233FeriadoTipo = new String[] {""} ;
      P01BD2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01BD2_A1226FerAnio = new short[1] ;
      P01BD2_A1228FerDescrip = new String[] {""} ;
      AV35Option = "" ;
      P01BD3_A1228FerDescrip = new String[] {""} ;
      P01BD3_A46PaiCod = new short[1] ;
      P01BD3_A1234FeriadoConvenio = new String[] {""} ;
      P01BD3_n1234FeriadoConvenio = new boolean[] {false} ;
      P01BD3_A1233FeriadoTipo = new String[] {""} ;
      P01BD3_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01BD3_A1226FerAnio = new short[1] ;
      P01BD3_A1223FerId = new String[] {""} ;
      P01BD4_A1234FeriadoConvenio = new String[] {""} ;
      P01BD4_n1234FeriadoConvenio = new boolean[] {false} ;
      P01BD4_A46PaiCod = new short[1] ;
      P01BD4_A1233FeriadoTipo = new String[] {""} ;
      P01BD4_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01BD4_A1226FerAnio = new short[1] ;
      P01BD4_A1228FerDescrip = new String[] {""} ;
      P01BD4_A1223FerId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriado_agendawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01BD2_A1223FerId, P01BD2_A46PaiCod, P01BD2_A1234FeriadoConvenio, P01BD2_n1234FeriadoConvenio, P01BD2_A1233FeriadoTipo, P01BD2_A1227FerFecha, P01BD2_A1226FerAnio, P01BD2_A1228FerDescrip
            }
            , new Object[] {
            P01BD3_A1228FerDescrip, P01BD3_A46PaiCod, P01BD3_A1234FeriadoConvenio, P01BD3_n1234FeriadoConvenio, P01BD3_A1233FeriadoTipo, P01BD3_A1227FerFecha, P01BD3_A1226FerAnio, P01BD3_A1223FerId
            }
            , new Object[] {
            P01BD4_A1234FeriadoConvenio, P01BD4_n1234FeriadoConvenio, P01BD4_A46PaiCod, P01BD4_A1233FeriadoTipo, P01BD4_A1227FerFecha, P01BD4_A1226FerAnio, P01BD4_A1228FerDescrip, P01BD4_A1223FerId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV53EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV16TFFerAnio ;
   private short AV17TFFerAnio_To ;
   private short AV86Feriado_agendawwds_5_tfferanio ;
   private short AV87Feriado_agendawwds_6_tfferanio_to ;
   private short AV70PaiCod ;
   private short A1226FerAnio ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV54CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV80GXV1 ;
   private int AV83Feriado_agendawwds_2_tfferid_sels_size ;
   private int AV85Feriado_agendawwds_4_tfferdescrip_sels_size ;
   private int AV90Feriado_agendawwds_9_tfferiadotipo_sels_size ;
   private int AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size ;
   private long AV40count ;
   private String AV14TFFerId ;
   private String AV32TFFeriadoConvenio ;
   private String A1223FerId ;
   private String AV82Feriado_agendawwds_1_tfferid ;
   private String AV91Feriado_agendawwds_10_tfferiadoconvenio ;
   private String scmdbuf ;
   private String lV82Feriado_agendawwds_1_tfferid ;
   private String lV91Feriado_agendawwds_10_tfferiadoconvenio ;
   private String A1233FeriadoTipo ;
   private String A1234FeriadoConvenio ;
   private java.util.Date AV18TFFerFecha ;
   private java.util.Date AV19TFFerFecha_To ;
   private java.util.Date AV88Feriado_agendawwds_7_tfferfecha ;
   private java.util.Date AV89Feriado_agendawwds_8_tfferfecha_to ;
   private java.util.Date A1227FerFecha ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1BD2 ;
   private boolean n1234FeriadoConvenio ;
   private boolean brk1BD4 ;
   private boolean brk1BD6 ;
   private String AV49OptionsJson ;
   private String AV50OptionsDescJson ;
   private String AV51OptionIndexesJson ;
   private String AV13TFFerId_SelsJson ;
   private String AV20TFFerDescrip_SelsJson ;
   private String AV55TFFeriadoTipo_SelsJson ;
   private String AV31TFFeriadoConvenio_SelsJson ;
   private String AV46DDOName ;
   private String AV47SearchTxt ;
   private String AV48SearchTxtTo ;
   private String AV21TFFerDescrip ;
   private String AV77MenuOpcCod ;
   private String AV84Feriado_agendawwds_3_tfferdescrip ;
   private String lV84Feriado_agendawwds_3_tfferdescrip ;
   private String A1228FerDescrip ;
   private String AV35Option ;
   private com.genexus.webpanels.WebSession AV41Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BD2_A1223FerId ;
   private short[] P01BD2_A46PaiCod ;
   private String[] P01BD2_A1234FeriadoConvenio ;
   private boolean[] P01BD2_n1234FeriadoConvenio ;
   private String[] P01BD2_A1233FeriadoTipo ;
   private java.util.Date[] P01BD2_A1227FerFecha ;
   private short[] P01BD2_A1226FerAnio ;
   private String[] P01BD2_A1228FerDescrip ;
   private String[] P01BD3_A1228FerDescrip ;
   private short[] P01BD3_A46PaiCod ;
   private String[] P01BD3_A1234FeriadoConvenio ;
   private boolean[] P01BD3_n1234FeriadoConvenio ;
   private String[] P01BD3_A1233FeriadoTipo ;
   private java.util.Date[] P01BD3_A1227FerFecha ;
   private short[] P01BD3_A1226FerAnio ;
   private String[] P01BD3_A1223FerId ;
   private String[] P01BD4_A1234FeriadoConvenio ;
   private boolean[] P01BD4_n1234FeriadoConvenio ;
   private short[] P01BD4_A46PaiCod ;
   private String[] P01BD4_A1233FeriadoTipo ;
   private java.util.Date[] P01BD4_A1227FerFecha ;
   private short[] P01BD4_A1226FerAnio ;
   private String[] P01BD4_A1228FerDescrip ;
   private String[] P01BD4_A1223FerId ;
   private GXSimpleCollection<String> AV15TFFerId_Sels ;
   private GXSimpleCollection<String> AV56TFFeriadoTipo_Sels ;
   private GXSimpleCollection<String> AV33TFFeriadoConvenio_Sels ;
   private GXSimpleCollection<String> AV83Feriado_agendawwds_2_tfferid_sels ;
   private GXSimpleCollection<String> AV90Feriado_agendawwds_9_tfferiadotipo_sels ;
   private GXSimpleCollection<String> AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ;
   private GXSimpleCollection<String> AV36Options ;
   private GXSimpleCollection<String> AV38OptionsDesc ;
   private GXSimpleCollection<String> AV39OptionIndexes ;
   private GXSimpleCollection<String> AV22TFFerDescrip_Sels ;
   private GXSimpleCollection<String> AV85Feriado_agendawwds_4_tfferdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV43GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV44GridStateFilterValue ;
}

final  class feriado_agendawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01BD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV83Feriado_agendawwds_2_tfferid_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV85Feriado_agendawwds_4_tfferdescrip_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV90Feriado_agendawwds_9_tfferiadotipo_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                          int AV83Feriado_agendawwds_2_tfferid_sels_size ,
                                          String AV82Feriado_agendawwds_1_tfferid ,
                                          int AV85Feriado_agendawwds_4_tfferdescrip_sels_size ,
                                          String AV84Feriado_agendawwds_3_tfferdescrip ,
                                          short AV86Feriado_agendawwds_5_tfferanio ,
                                          short AV87Feriado_agendawwds_6_tfferanio_to ,
                                          java.util.Date AV88Feriado_agendawwds_7_tfferfecha ,
                                          java.util.Date AV89Feriado_agendawwds_8_tfferfecha_to ,
                                          int AV90Feriado_agendawwds_9_tfferiadotipo_sels_size ,
                                          int AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size ,
                                          String AV91Feriado_agendawwds_10_tfferiadoconvenio ,
                                          short AV70PaiCod ,
                                          short A1226FerAnio ,
                                          java.util.Date A1227FerFecha ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.FerId, T1.PaiCod, T2.FeriadoConvenio, T2.FeriadoTipo, T1.FerFecha, T1.FerAnio, T2.FerDescrip FROM (feriado_agenda T1 INNER JOIN feriado T2 ON T2.PaiCod" ;
      scmdbuf += " = T1.PaiCod AND T2.FerId = T1.FerId)" ;
      if ( ( AV83Feriado_agendawwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Feriado_agendawwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.FerId) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV83Feriado_agendawwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Feriado_agendawwds_2_tfferid_sels, "T1.FerId IN (", ")")+")");
      }
      if ( ( AV85Feriado_agendawwds_4_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV84Feriado_agendawwds_3_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV85Feriado_agendawwds_4_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Feriado_agendawwds_4_tfferdescrip_sels, "T2.FerDescrip IN (", ")")+")");
      }
      if ( ! (0==AV86Feriado_agendawwds_5_tfferanio) )
      {
         addWhere(sWhereString, "(T1.FerAnio >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV87Feriado_agendawwds_6_tfferanio_to) )
      {
         addWhere(sWhereString, "(T1.FerAnio <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV88Feriado_agendawwds_7_tfferfecha)) )
      {
         addWhere(sWhereString, "(T1.FerFecha >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV89Feriado_agendawwds_8_tfferfecha_to)) )
      {
         addWhere(sWhereString, "(T1.FerFecha <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV90Feriado_agendawwds_9_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Feriado_agendawwds_9_tfferiadotipo_sels, "T2.FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV91Feriado_agendawwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Feriado_agendawwds_11_tfferiadoconvenio_sels, "T2.FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV70PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.FerId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01BD3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV83Feriado_agendawwds_2_tfferid_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV85Feriado_agendawwds_4_tfferdescrip_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV90Feriado_agendawwds_9_tfferiadotipo_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                          int AV83Feriado_agendawwds_2_tfferid_sels_size ,
                                          String AV82Feriado_agendawwds_1_tfferid ,
                                          int AV85Feriado_agendawwds_4_tfferdescrip_sels_size ,
                                          String AV84Feriado_agendawwds_3_tfferdescrip ,
                                          short AV86Feriado_agendawwds_5_tfferanio ,
                                          short AV87Feriado_agendawwds_6_tfferanio_to ,
                                          java.util.Date AV88Feriado_agendawwds_7_tfferfecha ,
                                          java.util.Date AV89Feriado_agendawwds_8_tfferfecha_to ,
                                          int AV90Feriado_agendawwds_9_tfferiadotipo_sels_size ,
                                          int AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size ,
                                          String AV91Feriado_agendawwds_10_tfferiadoconvenio ,
                                          short AV70PaiCod ,
                                          short A1226FerAnio ,
                                          java.util.Date A1227FerFecha ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T2.FerDescrip, T1.PaiCod, T2.FeriadoConvenio, T2.FeriadoTipo, T1.FerFecha, T1.FerAnio, T1.FerId FROM (feriado_agenda T1 INNER JOIN feriado T2 ON T2.PaiCod" ;
      scmdbuf += " = T1.PaiCod AND T2.FerId = T1.FerId)" ;
      if ( ( AV83Feriado_agendawwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Feriado_agendawwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.FerId) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV83Feriado_agendawwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Feriado_agendawwds_2_tfferid_sels, "T1.FerId IN (", ")")+")");
      }
      if ( ( AV85Feriado_agendawwds_4_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV84Feriado_agendawwds_3_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV85Feriado_agendawwds_4_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Feriado_agendawwds_4_tfferdescrip_sels, "T2.FerDescrip IN (", ")")+")");
      }
      if ( ! (0==AV86Feriado_agendawwds_5_tfferanio) )
      {
         addWhere(sWhereString, "(T1.FerAnio >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV87Feriado_agendawwds_6_tfferanio_to) )
      {
         addWhere(sWhereString, "(T1.FerAnio <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV88Feriado_agendawwds_7_tfferfecha)) )
      {
         addWhere(sWhereString, "(T1.FerFecha >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV89Feriado_agendawwds_8_tfferfecha_to)) )
      {
         addWhere(sWhereString, "(T1.FerFecha <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV90Feriado_agendawwds_9_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Feriado_agendawwds_9_tfferiadotipo_sels, "T2.FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV91Feriado_agendawwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Feriado_agendawwds_11_tfferiadoconvenio_sels, "T2.FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV70PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.FerDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01BD4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV83Feriado_agendawwds_2_tfferid_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV85Feriado_agendawwds_4_tfferdescrip_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV90Feriado_agendawwds_9_tfferiadotipo_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV92Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                          int AV83Feriado_agendawwds_2_tfferid_sels_size ,
                                          String AV82Feriado_agendawwds_1_tfferid ,
                                          int AV85Feriado_agendawwds_4_tfferdescrip_sels_size ,
                                          String AV84Feriado_agendawwds_3_tfferdescrip ,
                                          short AV86Feriado_agendawwds_5_tfferanio ,
                                          short AV87Feriado_agendawwds_6_tfferanio_to ,
                                          java.util.Date AV88Feriado_agendawwds_7_tfferfecha ,
                                          java.util.Date AV89Feriado_agendawwds_8_tfferfecha_to ,
                                          int AV90Feriado_agendawwds_9_tfferiadotipo_sels_size ,
                                          int AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size ,
                                          String AV91Feriado_agendawwds_10_tfferiadoconvenio ,
                                          short AV70PaiCod ,
                                          short A1226FerAnio ,
                                          java.util.Date A1227FerFecha ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[8];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T2.FeriadoConvenio, T1.PaiCod, T2.FeriadoTipo, T1.FerFecha, T1.FerAnio, T2.FerDescrip, T1.FerId FROM (feriado_agenda T1 INNER JOIN feriado T2 ON T2.PaiCod" ;
      scmdbuf += " = T1.PaiCod AND T2.FerId = T1.FerId)" ;
      if ( ( AV83Feriado_agendawwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Feriado_agendawwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.FerId) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV83Feriado_agendawwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Feriado_agendawwds_2_tfferid_sels, "T1.FerId IN (", ")")+")");
      }
      if ( ( AV85Feriado_agendawwds_4_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV84Feriado_agendawwds_3_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV85Feriado_agendawwds_4_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Feriado_agendawwds_4_tfferdescrip_sels, "T2.FerDescrip IN (", ")")+")");
      }
      if ( ! (0==AV86Feriado_agendawwds_5_tfferanio) )
      {
         addWhere(sWhereString, "(T1.FerAnio >= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ! (0==AV87Feriado_agendawwds_6_tfferanio_to) )
      {
         addWhere(sWhereString, "(T1.FerAnio <= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV88Feriado_agendawwds_7_tfferfecha)) )
      {
         addWhere(sWhereString, "(T1.FerFecha >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV89Feriado_agendawwds_8_tfferfecha_to)) )
      {
         addWhere(sWhereString, "(T1.FerFecha <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV90Feriado_agendawwds_9_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Feriado_agendawwds_9_tfferiadotipo_sels, "T2.FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV91Feriado_agendawwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV92Feriado_agendawwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Feriado_agendawwds_11_tfferiadoconvenio_sels, "T2.FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV70PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.FeriadoConvenio" ;
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
                  return conditional_P01BD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.util.Date)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() );
            case 1 :
                  return conditional_P01BD3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.util.Date)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() );
            case 2 :
                  return conditional_P01BD4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.util.Date)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01BD3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01BD4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
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
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               return;
      }
   }

}


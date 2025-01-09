package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class feriadowwgetfilterdata extends GXProcedure
{
   public feriadowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriadowwgetfilterdata.class ), "" );
   }

   public feriadowwgetfilterdata( int remoteHandle ,
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
      feriadowwgetfilterdata.this.aP5 = new String[] {""};
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
      feriadowwgetfilterdata.this.AV44DDOName = aP0;
      feriadowwgetfilterdata.this.AV45SearchTxt = aP1;
      feriadowwgetfilterdata.this.AV46SearchTxtTo = aP2;
      feriadowwgetfilterdata.this.aP3 = aP3;
      feriadowwgetfilterdata.this.aP4 = aP4;
      feriadowwgetfilterdata.this.aP5 = aP5;
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
      feriadowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV51EmpCod = GXt_int1 ;
      GXt_int3 = AV52CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      feriadowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV52CliCod = GXt_int3 ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado", GXv_boolean6) ;
      feriadowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_FERID") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_FERDESCRIP") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_FERRELIGID") == 0 )
         {
            /* Execute user subroutine: 'LOADFERRELIGIDOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_FERORIGID") == 0 )
         {
            /* Execute user subroutine: 'LOADFERORIGIDOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_FERIADOCONVENIO") == 0 )
         {
            /* Execute user subroutine: 'LOADFERIADOCONVENIOOPTIONS' */
            S161 ();
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
      if ( GXutil.strcmp(AV39Session.getValue("feriadoWWGridState"), "") == 0 )
      {
         AV41GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "feriadoWWGridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV39Session.getValue("feriadoWWGridState"), null, null);
      }
      AV57GXV1 = 1 ;
      while ( AV57GXV1 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV57GXV1));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID") == 0 )
         {
            AV12TFFerId = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID_SEL") == 0 )
         {
            AV11TFFerId_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFFerId_Sels.fromJSonString(AV11TFFerId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOTIPO_SEL") == 0 )
         {
            AV14TFFeriadoTipo_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFFeriadoTipo_Sels.fromJSonString(AV14TFFeriadoTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP") == 0 )
         {
            AV21TFFerDescrip = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP_SEL") == 0 )
         {
            AV20TFFerDescrip_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFFerDescrip_Sels.fromJSonString(AV20TFFerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERRELIGID") == 0 )
         {
            AV24TFFerReligId = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERRELIGID_SEL") == 0 )
         {
            AV23TFFerReligId_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV25TFFerReligId_Sels.fromJSonString(AV23TFFerReligId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERORIGID") == 0 )
         {
            AV27TFFerOrigId = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERORIGID_SEL") == 0 )
         {
            AV26TFFerOrigId_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV28TFFerOrigId_Sels.fromJSonString(AV26TFFerOrigId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO") == 0 )
         {
            AV30TFFeriadoConvenio = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO_SEL") == 0 )
         {
            AV29TFFeriadoConvenio_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV31TFFeriadoConvenio_Sels.fromJSonString(AV29TFFeriadoConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV57GXV1 = (int)(AV57GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADFERIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFFerId = AV45SearchTxt ;
      AV13TFFerId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Feriadowwds_1_tfferid = AV12TFFerId ;
      AV60Feriadowwds_2_tfferid_sels = AV13TFFerId_Sels ;
      AV61Feriadowwds_3_tfferiadotipo_sels = AV15TFFeriadoTipo_Sels ;
      AV62Feriadowwds_4_tfferdescrip = AV21TFFerDescrip ;
      AV63Feriadowwds_5_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV64Feriadowwds_6_tfferreligid = AV24TFFerReligId ;
      AV65Feriadowwds_7_tfferreligid_sels = AV25TFFerReligId_Sels ;
      AV66Feriadowwds_8_tfferorigid = AV27TFFerOrigId ;
      AV67Feriadowwds_9_tfferorigid_sels = AV28TFFerOrigId_Sels ;
      AV68Feriadowwds_10_tfferiadoconvenio = AV30TFFeriadoConvenio ;
      AV69Feriadowwds_11_tfferiadoconvenio_sels = AV31TFFeriadoConvenio_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV60Feriadowwds_2_tfferid_sels ,
                                           A1233FeriadoTipo ,
                                           AV61Feriadowwds_3_tfferiadotipo_sels ,
                                           A1228FerDescrip ,
                                           AV63Feriadowwds_5_tfferdescrip_sels ,
                                           A1230FerReligId ,
                                           AV65Feriadowwds_7_tfferreligid_sels ,
                                           A1232FerOrigId ,
                                           AV67Feriadowwds_9_tfferorigid_sels ,
                                           A1234FeriadoConvenio ,
                                           AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV60Feriadowwds_2_tfferid_sels.size()) ,
                                           AV59Feriadowwds_1_tfferid ,
                                           Integer.valueOf(AV61Feriadowwds_3_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV63Feriadowwds_5_tfferdescrip_sels.size()) ,
                                           AV62Feriadowwds_4_tfferdescrip ,
                                           Integer.valueOf(AV65Feriadowwds_7_tfferreligid_sels.size()) ,
                                           AV64Feriadowwds_6_tfferreligid ,
                                           Integer.valueOf(AV67Feriadowwds_9_tfferorigid_sels.size()) ,
                                           AV66Feriadowwds_8_tfferorigid ,
                                           Integer.valueOf(AV69Feriadowwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV68Feriadowwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV53PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV59Feriadowwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV59Feriadowwds_1_tfferid), 40, "%") ;
      lV62Feriadowwds_4_tfferdescrip = GXutil.concat( GXutil.rtrim( AV62Feriadowwds_4_tfferdescrip), "%", "") ;
      lV64Feriadowwds_6_tfferreligid = GXutil.padr( GXutil.rtrim( AV64Feriadowwds_6_tfferreligid), 20, "%") ;
      lV66Feriadowwds_8_tfferorigid = GXutil.padr( GXutil.rtrim( AV66Feriadowwds_8_tfferorigid), 20, "%") ;
      lV68Feriadowwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV68Feriadowwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01HN2 */
      pr_default.execute(0, new Object[] {lV59Feriadowwds_1_tfferid, lV62Feriadowwds_4_tfferdescrip, lV64Feriadowwds_6_tfferreligid, lV66Feriadowwds_8_tfferorigid, lV68Feriadowwds_10_tfferiadoconvenio, Short.valueOf(AV53PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1HN2 = false ;
         A1223FerId = P01HN2_A1223FerId[0] ;
         A46PaiCod = P01HN2_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01HN2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01HN2_n1234FeriadoConvenio[0] ;
         A1232FerOrigId = P01HN2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01HN2_n1232FerOrigId[0] ;
         A1230FerReligId = P01HN2_A1230FerReligId[0] ;
         n1230FerReligId = P01HN2_n1230FerReligId[0] ;
         A1228FerDescrip = P01HN2_A1228FerDescrip[0] ;
         A1233FeriadoTipo = P01HN2_A1233FeriadoTipo[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01HN2_A1223FerId[0], A1223FerId) == 0 ) )
         {
            brk1HN2 = false ;
            A46PaiCod = P01HN2_A46PaiCod[0] ;
            AV38count = (long)(AV38count+1) ;
            brk1HN2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1223FerId)==0) )
         {
            AV33Option = A1223FerId ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HN2 )
         {
            brk1HN2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADFERDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV21TFFerDescrip = AV45SearchTxt ;
      AV22TFFerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Feriadowwds_1_tfferid = AV12TFFerId ;
      AV60Feriadowwds_2_tfferid_sels = AV13TFFerId_Sels ;
      AV61Feriadowwds_3_tfferiadotipo_sels = AV15TFFeriadoTipo_Sels ;
      AV62Feriadowwds_4_tfferdescrip = AV21TFFerDescrip ;
      AV63Feriadowwds_5_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV64Feriadowwds_6_tfferreligid = AV24TFFerReligId ;
      AV65Feriadowwds_7_tfferreligid_sels = AV25TFFerReligId_Sels ;
      AV66Feriadowwds_8_tfferorigid = AV27TFFerOrigId ;
      AV67Feriadowwds_9_tfferorigid_sels = AV28TFFerOrigId_Sels ;
      AV68Feriadowwds_10_tfferiadoconvenio = AV30TFFeriadoConvenio ;
      AV69Feriadowwds_11_tfferiadoconvenio_sels = AV31TFFeriadoConvenio_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV60Feriadowwds_2_tfferid_sels ,
                                           A1233FeriadoTipo ,
                                           AV61Feriadowwds_3_tfferiadotipo_sels ,
                                           A1228FerDescrip ,
                                           AV63Feriadowwds_5_tfferdescrip_sels ,
                                           A1230FerReligId ,
                                           AV65Feriadowwds_7_tfferreligid_sels ,
                                           A1232FerOrigId ,
                                           AV67Feriadowwds_9_tfferorigid_sels ,
                                           A1234FeriadoConvenio ,
                                           AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV60Feriadowwds_2_tfferid_sels.size()) ,
                                           AV59Feriadowwds_1_tfferid ,
                                           Integer.valueOf(AV61Feriadowwds_3_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV63Feriadowwds_5_tfferdescrip_sels.size()) ,
                                           AV62Feriadowwds_4_tfferdescrip ,
                                           Integer.valueOf(AV65Feriadowwds_7_tfferreligid_sels.size()) ,
                                           AV64Feriadowwds_6_tfferreligid ,
                                           Integer.valueOf(AV67Feriadowwds_9_tfferorigid_sels.size()) ,
                                           AV66Feriadowwds_8_tfferorigid ,
                                           Integer.valueOf(AV69Feriadowwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV68Feriadowwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV53PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV59Feriadowwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV59Feriadowwds_1_tfferid), 40, "%") ;
      lV62Feriadowwds_4_tfferdescrip = GXutil.concat( GXutil.rtrim( AV62Feriadowwds_4_tfferdescrip), "%", "") ;
      lV64Feriadowwds_6_tfferreligid = GXutil.padr( GXutil.rtrim( AV64Feriadowwds_6_tfferreligid), 20, "%") ;
      lV66Feriadowwds_8_tfferorigid = GXutil.padr( GXutil.rtrim( AV66Feriadowwds_8_tfferorigid), 20, "%") ;
      lV68Feriadowwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV68Feriadowwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01HN3 */
      pr_default.execute(1, new Object[] {lV59Feriadowwds_1_tfferid, lV62Feriadowwds_4_tfferdescrip, lV64Feriadowwds_6_tfferreligid, lV66Feriadowwds_8_tfferorigid, lV68Feriadowwds_10_tfferiadoconvenio, Short.valueOf(AV53PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1HN4 = false ;
         A1228FerDescrip = P01HN3_A1228FerDescrip[0] ;
         A46PaiCod = P01HN3_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01HN3_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01HN3_n1234FeriadoConvenio[0] ;
         A1232FerOrigId = P01HN3_A1232FerOrigId[0] ;
         n1232FerOrigId = P01HN3_n1232FerOrigId[0] ;
         A1230FerReligId = P01HN3_A1230FerReligId[0] ;
         n1230FerReligId = P01HN3_n1230FerReligId[0] ;
         A1233FeriadoTipo = P01HN3_A1233FeriadoTipo[0] ;
         A1223FerId = P01HN3_A1223FerId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01HN3_A1228FerDescrip[0], A1228FerDescrip) == 0 ) )
         {
            brk1HN4 = false ;
            A46PaiCod = P01HN3_A46PaiCod[0] ;
            A1223FerId = P01HN3_A1223FerId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk1HN4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1228FerDescrip)==0) )
         {
            AV33Option = A1228FerDescrip ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HN4 )
         {
            brk1HN4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADFERRELIGIDOPTIONS' Routine */
      returnInSub = false ;
      AV24TFFerReligId = AV45SearchTxt ;
      AV25TFFerReligId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Feriadowwds_1_tfferid = AV12TFFerId ;
      AV60Feriadowwds_2_tfferid_sels = AV13TFFerId_Sels ;
      AV61Feriadowwds_3_tfferiadotipo_sels = AV15TFFeriadoTipo_Sels ;
      AV62Feriadowwds_4_tfferdescrip = AV21TFFerDescrip ;
      AV63Feriadowwds_5_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV64Feriadowwds_6_tfferreligid = AV24TFFerReligId ;
      AV65Feriadowwds_7_tfferreligid_sels = AV25TFFerReligId_Sels ;
      AV66Feriadowwds_8_tfferorigid = AV27TFFerOrigId ;
      AV67Feriadowwds_9_tfferorigid_sels = AV28TFFerOrigId_Sels ;
      AV68Feriadowwds_10_tfferiadoconvenio = AV30TFFeriadoConvenio ;
      AV69Feriadowwds_11_tfferiadoconvenio_sels = AV31TFFeriadoConvenio_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV60Feriadowwds_2_tfferid_sels ,
                                           A1233FeriadoTipo ,
                                           AV61Feriadowwds_3_tfferiadotipo_sels ,
                                           A1228FerDescrip ,
                                           AV63Feriadowwds_5_tfferdescrip_sels ,
                                           A1230FerReligId ,
                                           AV65Feriadowwds_7_tfferreligid_sels ,
                                           A1232FerOrigId ,
                                           AV67Feriadowwds_9_tfferorigid_sels ,
                                           A1234FeriadoConvenio ,
                                           AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV60Feriadowwds_2_tfferid_sels.size()) ,
                                           AV59Feriadowwds_1_tfferid ,
                                           Integer.valueOf(AV61Feriadowwds_3_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV63Feriadowwds_5_tfferdescrip_sels.size()) ,
                                           AV62Feriadowwds_4_tfferdescrip ,
                                           Integer.valueOf(AV65Feriadowwds_7_tfferreligid_sels.size()) ,
                                           AV64Feriadowwds_6_tfferreligid ,
                                           Integer.valueOf(AV67Feriadowwds_9_tfferorigid_sels.size()) ,
                                           AV66Feriadowwds_8_tfferorigid ,
                                           Integer.valueOf(AV69Feriadowwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV68Feriadowwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV53PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV59Feriadowwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV59Feriadowwds_1_tfferid), 40, "%") ;
      lV62Feriadowwds_4_tfferdescrip = GXutil.concat( GXutil.rtrim( AV62Feriadowwds_4_tfferdescrip), "%", "") ;
      lV64Feriadowwds_6_tfferreligid = GXutil.padr( GXutil.rtrim( AV64Feriadowwds_6_tfferreligid), 20, "%") ;
      lV66Feriadowwds_8_tfferorigid = GXutil.padr( GXutil.rtrim( AV66Feriadowwds_8_tfferorigid), 20, "%") ;
      lV68Feriadowwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV68Feriadowwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01HN4 */
      pr_default.execute(2, new Object[] {lV59Feriadowwds_1_tfferid, lV62Feriadowwds_4_tfferdescrip, lV64Feriadowwds_6_tfferreligid, lV66Feriadowwds_8_tfferorigid, lV68Feriadowwds_10_tfferiadoconvenio, Short.valueOf(AV53PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1HN6 = false ;
         A1230FerReligId = P01HN4_A1230FerReligId[0] ;
         n1230FerReligId = P01HN4_n1230FerReligId[0] ;
         A46PaiCod = P01HN4_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01HN4_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01HN4_n1234FeriadoConvenio[0] ;
         A1232FerOrigId = P01HN4_A1232FerOrigId[0] ;
         n1232FerOrigId = P01HN4_n1232FerOrigId[0] ;
         A1228FerDescrip = P01HN4_A1228FerDescrip[0] ;
         A1233FeriadoTipo = P01HN4_A1233FeriadoTipo[0] ;
         A1223FerId = P01HN4_A1223FerId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01HN4_A1230FerReligId[0], A1230FerReligId) == 0 ) )
         {
            brk1HN6 = false ;
            A46PaiCod = P01HN4_A46PaiCod[0] ;
            A1223FerId = P01HN4_A1223FerId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk1HN6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1230FerReligId)==0) )
         {
            AV33Option = A1230FerReligId ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HN6 )
         {
            brk1HN6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADFERORIGIDOPTIONS' Routine */
      returnInSub = false ;
      AV27TFFerOrigId = AV45SearchTxt ;
      AV28TFFerOrigId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Feriadowwds_1_tfferid = AV12TFFerId ;
      AV60Feriadowwds_2_tfferid_sels = AV13TFFerId_Sels ;
      AV61Feriadowwds_3_tfferiadotipo_sels = AV15TFFeriadoTipo_Sels ;
      AV62Feriadowwds_4_tfferdescrip = AV21TFFerDescrip ;
      AV63Feriadowwds_5_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV64Feriadowwds_6_tfferreligid = AV24TFFerReligId ;
      AV65Feriadowwds_7_tfferreligid_sels = AV25TFFerReligId_Sels ;
      AV66Feriadowwds_8_tfferorigid = AV27TFFerOrigId ;
      AV67Feriadowwds_9_tfferorigid_sels = AV28TFFerOrigId_Sels ;
      AV68Feriadowwds_10_tfferiadoconvenio = AV30TFFeriadoConvenio ;
      AV69Feriadowwds_11_tfferiadoconvenio_sels = AV31TFFeriadoConvenio_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV60Feriadowwds_2_tfferid_sels ,
                                           A1233FeriadoTipo ,
                                           AV61Feriadowwds_3_tfferiadotipo_sels ,
                                           A1228FerDescrip ,
                                           AV63Feriadowwds_5_tfferdescrip_sels ,
                                           A1230FerReligId ,
                                           AV65Feriadowwds_7_tfferreligid_sels ,
                                           A1232FerOrigId ,
                                           AV67Feriadowwds_9_tfferorigid_sels ,
                                           A1234FeriadoConvenio ,
                                           AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV60Feriadowwds_2_tfferid_sels.size()) ,
                                           AV59Feriadowwds_1_tfferid ,
                                           Integer.valueOf(AV61Feriadowwds_3_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV63Feriadowwds_5_tfferdescrip_sels.size()) ,
                                           AV62Feriadowwds_4_tfferdescrip ,
                                           Integer.valueOf(AV65Feriadowwds_7_tfferreligid_sels.size()) ,
                                           AV64Feriadowwds_6_tfferreligid ,
                                           Integer.valueOf(AV67Feriadowwds_9_tfferorigid_sels.size()) ,
                                           AV66Feriadowwds_8_tfferorigid ,
                                           Integer.valueOf(AV69Feriadowwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV68Feriadowwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV53PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV59Feriadowwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV59Feriadowwds_1_tfferid), 40, "%") ;
      lV62Feriadowwds_4_tfferdescrip = GXutil.concat( GXutil.rtrim( AV62Feriadowwds_4_tfferdescrip), "%", "") ;
      lV64Feriadowwds_6_tfferreligid = GXutil.padr( GXutil.rtrim( AV64Feriadowwds_6_tfferreligid), 20, "%") ;
      lV66Feriadowwds_8_tfferorigid = GXutil.padr( GXutil.rtrim( AV66Feriadowwds_8_tfferorigid), 20, "%") ;
      lV68Feriadowwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV68Feriadowwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01HN5 */
      pr_default.execute(3, new Object[] {lV59Feriadowwds_1_tfferid, lV62Feriadowwds_4_tfferdescrip, lV64Feriadowwds_6_tfferreligid, lV66Feriadowwds_8_tfferorigid, lV68Feriadowwds_10_tfferiadoconvenio, Short.valueOf(AV53PaiCod)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk1HN8 = false ;
         A1232FerOrigId = P01HN5_A1232FerOrigId[0] ;
         n1232FerOrigId = P01HN5_n1232FerOrigId[0] ;
         A46PaiCod = P01HN5_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01HN5_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01HN5_n1234FeriadoConvenio[0] ;
         A1230FerReligId = P01HN5_A1230FerReligId[0] ;
         n1230FerReligId = P01HN5_n1230FerReligId[0] ;
         A1228FerDescrip = P01HN5_A1228FerDescrip[0] ;
         A1233FeriadoTipo = P01HN5_A1233FeriadoTipo[0] ;
         A1223FerId = P01HN5_A1223FerId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P01HN5_A1232FerOrigId[0], A1232FerOrigId) == 0 ) )
         {
            brk1HN8 = false ;
            A46PaiCod = P01HN5_A46PaiCod[0] ;
            A1223FerId = P01HN5_A1223FerId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk1HN8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A1232FerOrigId)==0) )
         {
            AV33Option = A1232FerOrigId ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HN8 )
         {
            brk1HN8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADFERIADOCONVENIOOPTIONS' Routine */
      returnInSub = false ;
      AV30TFFeriadoConvenio = AV45SearchTxt ;
      AV31TFFeriadoConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Feriadowwds_1_tfferid = AV12TFFerId ;
      AV60Feriadowwds_2_tfferid_sels = AV13TFFerId_Sels ;
      AV61Feriadowwds_3_tfferiadotipo_sels = AV15TFFeriadoTipo_Sels ;
      AV62Feriadowwds_4_tfferdescrip = AV21TFFerDescrip ;
      AV63Feriadowwds_5_tfferdescrip_sels = AV22TFFerDescrip_Sels ;
      AV64Feriadowwds_6_tfferreligid = AV24TFFerReligId ;
      AV65Feriadowwds_7_tfferreligid_sels = AV25TFFerReligId_Sels ;
      AV66Feriadowwds_8_tfferorigid = AV27TFFerOrigId ;
      AV67Feriadowwds_9_tfferorigid_sels = AV28TFFerOrigId_Sels ;
      AV68Feriadowwds_10_tfferiadoconvenio = AV30TFFeriadoConvenio ;
      AV69Feriadowwds_11_tfferiadoconvenio_sels = AV31TFFeriadoConvenio_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV60Feriadowwds_2_tfferid_sels ,
                                           A1233FeriadoTipo ,
                                           AV61Feriadowwds_3_tfferiadotipo_sels ,
                                           A1228FerDescrip ,
                                           AV63Feriadowwds_5_tfferdescrip_sels ,
                                           A1230FerReligId ,
                                           AV65Feriadowwds_7_tfferreligid_sels ,
                                           A1232FerOrigId ,
                                           AV67Feriadowwds_9_tfferorigid_sels ,
                                           A1234FeriadoConvenio ,
                                           AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV60Feriadowwds_2_tfferid_sels.size()) ,
                                           AV59Feriadowwds_1_tfferid ,
                                           Integer.valueOf(AV61Feriadowwds_3_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV63Feriadowwds_5_tfferdescrip_sels.size()) ,
                                           AV62Feriadowwds_4_tfferdescrip ,
                                           Integer.valueOf(AV65Feriadowwds_7_tfferreligid_sels.size()) ,
                                           AV64Feriadowwds_6_tfferreligid ,
                                           Integer.valueOf(AV67Feriadowwds_9_tfferorigid_sels.size()) ,
                                           AV66Feriadowwds_8_tfferorigid ,
                                           Integer.valueOf(AV69Feriadowwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV68Feriadowwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV53PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV59Feriadowwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV59Feriadowwds_1_tfferid), 40, "%") ;
      lV62Feriadowwds_4_tfferdescrip = GXutil.concat( GXutil.rtrim( AV62Feriadowwds_4_tfferdescrip), "%", "") ;
      lV64Feriadowwds_6_tfferreligid = GXutil.padr( GXutil.rtrim( AV64Feriadowwds_6_tfferreligid), 20, "%") ;
      lV66Feriadowwds_8_tfferorigid = GXutil.padr( GXutil.rtrim( AV66Feriadowwds_8_tfferorigid), 20, "%") ;
      lV68Feriadowwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV68Feriadowwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01HN6 */
      pr_default.execute(4, new Object[] {lV59Feriadowwds_1_tfferid, lV62Feriadowwds_4_tfferdescrip, lV64Feriadowwds_6_tfferreligid, lV66Feriadowwds_8_tfferorigid, lV68Feriadowwds_10_tfferiadoconvenio, Short.valueOf(AV53PaiCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk1HN10 = false ;
         A1234FeriadoConvenio = P01HN6_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01HN6_n1234FeriadoConvenio[0] ;
         A46PaiCod = P01HN6_A46PaiCod[0] ;
         A1232FerOrigId = P01HN6_A1232FerOrigId[0] ;
         n1232FerOrigId = P01HN6_n1232FerOrigId[0] ;
         A1230FerReligId = P01HN6_A1230FerReligId[0] ;
         n1230FerReligId = P01HN6_n1230FerReligId[0] ;
         A1228FerDescrip = P01HN6_A1228FerDescrip[0] ;
         A1233FeriadoTipo = P01HN6_A1233FeriadoTipo[0] ;
         A1223FerId = P01HN6_A1223FerId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P01HN6_A1234FeriadoConvenio[0], A1234FeriadoConvenio) == 0 ) )
         {
            brk1HN10 = false ;
            A46PaiCod = P01HN6_A46PaiCod[0] ;
            A1223FerId = P01HN6_A1223FerId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk1HN10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A1234FeriadoConvenio)==0) )
         {
            AV33Option = A1234FeriadoConvenio ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HN10 )
         {
            brk1HN10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      this.aP3[0] = feriadowwgetfilterdata.this.AV47OptionsJson;
      this.aP4[0] = feriadowwgetfilterdata.this.AV48OptionsDescJson;
      this.aP5[0] = feriadowwgetfilterdata.this.AV49OptionIndexesJson;
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
      AV12TFFerId = "" ;
      AV11TFFerId_SelsJson = "" ;
      AV13TFFerId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFFeriadoTipo_SelsJson = "" ;
      AV15TFFeriadoTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFFerDescrip = "" ;
      AV20TFFerDescrip_SelsJson = "" ;
      AV22TFFerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24TFFerReligId = "" ;
      AV23TFFerReligId_SelsJson = "" ;
      AV25TFFerReligId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27TFFerOrigId = "" ;
      AV26TFFerOrigId_SelsJson = "" ;
      AV28TFFerOrigId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30TFFeriadoConvenio = "" ;
      AV29TFFeriadoConvenio_SelsJson = "" ;
      AV31TFFeriadoConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54MenuOpcCod = "" ;
      A1223FerId = "" ;
      AV59Feriadowwds_1_tfferid = "" ;
      AV60Feriadowwds_2_tfferid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Feriadowwds_3_tfferiadotipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Feriadowwds_4_tfferdescrip = "" ;
      AV63Feriadowwds_5_tfferdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Feriadowwds_6_tfferreligid = "" ;
      AV65Feriadowwds_7_tfferreligid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Feriadowwds_8_tfferorigid = "" ;
      AV67Feriadowwds_9_tfferorigid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Feriadowwds_10_tfferiadoconvenio = "" ;
      AV69Feriadowwds_11_tfferiadoconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV59Feriadowwds_1_tfferid = "" ;
      lV62Feriadowwds_4_tfferdescrip = "" ;
      lV64Feriadowwds_6_tfferreligid = "" ;
      lV66Feriadowwds_8_tfferorigid = "" ;
      lV68Feriadowwds_10_tfferiadoconvenio = "" ;
      A1233FeriadoTipo = "" ;
      A1228FerDescrip = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1234FeriadoConvenio = "" ;
      P01HN2_A1223FerId = new String[] {""} ;
      P01HN2_A46PaiCod = new short[1] ;
      P01HN2_A1234FeriadoConvenio = new String[] {""} ;
      P01HN2_n1234FeriadoConvenio = new boolean[] {false} ;
      P01HN2_A1232FerOrigId = new String[] {""} ;
      P01HN2_n1232FerOrigId = new boolean[] {false} ;
      P01HN2_A1230FerReligId = new String[] {""} ;
      P01HN2_n1230FerReligId = new boolean[] {false} ;
      P01HN2_A1228FerDescrip = new String[] {""} ;
      P01HN2_A1233FeriadoTipo = new String[] {""} ;
      AV33Option = "" ;
      P01HN3_A1228FerDescrip = new String[] {""} ;
      P01HN3_A46PaiCod = new short[1] ;
      P01HN3_A1234FeriadoConvenio = new String[] {""} ;
      P01HN3_n1234FeriadoConvenio = new boolean[] {false} ;
      P01HN3_A1232FerOrigId = new String[] {""} ;
      P01HN3_n1232FerOrigId = new boolean[] {false} ;
      P01HN3_A1230FerReligId = new String[] {""} ;
      P01HN3_n1230FerReligId = new boolean[] {false} ;
      P01HN3_A1233FeriadoTipo = new String[] {""} ;
      P01HN3_A1223FerId = new String[] {""} ;
      P01HN4_A1230FerReligId = new String[] {""} ;
      P01HN4_n1230FerReligId = new boolean[] {false} ;
      P01HN4_A46PaiCod = new short[1] ;
      P01HN4_A1234FeriadoConvenio = new String[] {""} ;
      P01HN4_n1234FeriadoConvenio = new boolean[] {false} ;
      P01HN4_A1232FerOrigId = new String[] {""} ;
      P01HN4_n1232FerOrigId = new boolean[] {false} ;
      P01HN4_A1228FerDescrip = new String[] {""} ;
      P01HN4_A1233FeriadoTipo = new String[] {""} ;
      P01HN4_A1223FerId = new String[] {""} ;
      P01HN5_A1232FerOrigId = new String[] {""} ;
      P01HN5_n1232FerOrigId = new boolean[] {false} ;
      P01HN5_A46PaiCod = new short[1] ;
      P01HN5_A1234FeriadoConvenio = new String[] {""} ;
      P01HN5_n1234FeriadoConvenio = new boolean[] {false} ;
      P01HN5_A1230FerReligId = new String[] {""} ;
      P01HN5_n1230FerReligId = new boolean[] {false} ;
      P01HN5_A1228FerDescrip = new String[] {""} ;
      P01HN5_A1233FeriadoTipo = new String[] {""} ;
      P01HN5_A1223FerId = new String[] {""} ;
      P01HN6_A1234FeriadoConvenio = new String[] {""} ;
      P01HN6_n1234FeriadoConvenio = new boolean[] {false} ;
      P01HN6_A46PaiCod = new short[1] ;
      P01HN6_A1232FerOrigId = new String[] {""} ;
      P01HN6_n1232FerOrigId = new boolean[] {false} ;
      P01HN6_A1230FerReligId = new String[] {""} ;
      P01HN6_n1230FerReligId = new boolean[] {false} ;
      P01HN6_A1228FerDescrip = new String[] {""} ;
      P01HN6_A1233FeriadoTipo = new String[] {""} ;
      P01HN6_A1223FerId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriadowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HN2_A1223FerId, P01HN2_A46PaiCod, P01HN2_A1234FeriadoConvenio, P01HN2_n1234FeriadoConvenio, P01HN2_A1232FerOrigId, P01HN2_n1232FerOrigId, P01HN2_A1230FerReligId, P01HN2_n1230FerReligId, P01HN2_A1228FerDescrip, P01HN2_A1233FeriadoTipo
            }
            , new Object[] {
            P01HN3_A1228FerDescrip, P01HN3_A46PaiCod, P01HN3_A1234FeriadoConvenio, P01HN3_n1234FeriadoConvenio, P01HN3_A1232FerOrigId, P01HN3_n1232FerOrigId, P01HN3_A1230FerReligId, P01HN3_n1230FerReligId, P01HN3_A1233FeriadoTipo, P01HN3_A1223FerId
            }
            , new Object[] {
            P01HN4_A1230FerReligId, P01HN4_n1230FerReligId, P01HN4_A46PaiCod, P01HN4_A1234FeriadoConvenio, P01HN4_n1234FeriadoConvenio, P01HN4_A1232FerOrigId, P01HN4_n1232FerOrigId, P01HN4_A1228FerDescrip, P01HN4_A1233FeriadoTipo, P01HN4_A1223FerId
            }
            , new Object[] {
            P01HN5_A1232FerOrigId, P01HN5_n1232FerOrigId, P01HN5_A46PaiCod, P01HN5_A1234FeriadoConvenio, P01HN5_n1234FeriadoConvenio, P01HN5_A1230FerReligId, P01HN5_n1230FerReligId, P01HN5_A1228FerDescrip, P01HN5_A1233FeriadoTipo, P01HN5_A1223FerId
            }
            , new Object[] {
            P01HN6_A1234FeriadoConvenio, P01HN6_n1234FeriadoConvenio, P01HN6_A46PaiCod, P01HN6_A1232FerOrigId, P01HN6_n1232FerOrigId, P01HN6_A1230FerReligId, P01HN6_n1230FerReligId, P01HN6_A1228FerDescrip, P01HN6_A1233FeriadoTipo, P01HN6_A1223FerId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV51EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV53PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV52CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV57GXV1 ;
   private int AV60Feriadowwds_2_tfferid_sels_size ;
   private int AV61Feriadowwds_3_tfferiadotipo_sels_size ;
   private int AV63Feriadowwds_5_tfferdescrip_sels_size ;
   private int AV65Feriadowwds_7_tfferreligid_sels_size ;
   private int AV67Feriadowwds_9_tfferorigid_sels_size ;
   private int AV69Feriadowwds_11_tfferiadoconvenio_sels_size ;
   private long AV38count ;
   private String AV12TFFerId ;
   private String AV24TFFerReligId ;
   private String AV27TFFerOrigId ;
   private String AV30TFFeriadoConvenio ;
   private String A1223FerId ;
   private String AV59Feriadowwds_1_tfferid ;
   private String AV64Feriadowwds_6_tfferreligid ;
   private String AV66Feriadowwds_8_tfferorigid ;
   private String AV68Feriadowwds_10_tfferiadoconvenio ;
   private String scmdbuf ;
   private String lV59Feriadowwds_1_tfferid ;
   private String lV64Feriadowwds_6_tfferreligid ;
   private String lV66Feriadowwds_8_tfferorigid ;
   private String lV68Feriadowwds_10_tfferiadoconvenio ;
   private String A1233FeriadoTipo ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1234FeriadoConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1HN2 ;
   private boolean n1234FeriadoConvenio ;
   private boolean n1232FerOrigId ;
   private boolean n1230FerReligId ;
   private boolean brk1HN4 ;
   private boolean brk1HN6 ;
   private boolean brk1HN8 ;
   private boolean brk1HN10 ;
   private String AV47OptionsJson ;
   private String AV48OptionsDescJson ;
   private String AV49OptionIndexesJson ;
   private String AV11TFFerId_SelsJson ;
   private String AV14TFFeriadoTipo_SelsJson ;
   private String AV20TFFerDescrip_SelsJson ;
   private String AV23TFFerReligId_SelsJson ;
   private String AV26TFFerOrigId_SelsJson ;
   private String AV29TFFeriadoConvenio_SelsJson ;
   private String AV44DDOName ;
   private String AV45SearchTxt ;
   private String AV46SearchTxtTo ;
   private String AV21TFFerDescrip ;
   private String AV54MenuOpcCod ;
   private String AV62Feriadowwds_4_tfferdescrip ;
   private String lV62Feriadowwds_4_tfferdescrip ;
   private String A1228FerDescrip ;
   private String AV33Option ;
   private com.genexus.webpanels.WebSession AV39Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HN2_A1223FerId ;
   private short[] P01HN2_A46PaiCod ;
   private String[] P01HN2_A1234FeriadoConvenio ;
   private boolean[] P01HN2_n1234FeriadoConvenio ;
   private String[] P01HN2_A1232FerOrigId ;
   private boolean[] P01HN2_n1232FerOrigId ;
   private String[] P01HN2_A1230FerReligId ;
   private boolean[] P01HN2_n1230FerReligId ;
   private String[] P01HN2_A1228FerDescrip ;
   private String[] P01HN2_A1233FeriadoTipo ;
   private String[] P01HN3_A1228FerDescrip ;
   private short[] P01HN3_A46PaiCod ;
   private String[] P01HN3_A1234FeriadoConvenio ;
   private boolean[] P01HN3_n1234FeriadoConvenio ;
   private String[] P01HN3_A1232FerOrigId ;
   private boolean[] P01HN3_n1232FerOrigId ;
   private String[] P01HN3_A1230FerReligId ;
   private boolean[] P01HN3_n1230FerReligId ;
   private String[] P01HN3_A1233FeriadoTipo ;
   private String[] P01HN3_A1223FerId ;
   private String[] P01HN4_A1230FerReligId ;
   private boolean[] P01HN4_n1230FerReligId ;
   private short[] P01HN4_A46PaiCod ;
   private String[] P01HN4_A1234FeriadoConvenio ;
   private boolean[] P01HN4_n1234FeriadoConvenio ;
   private String[] P01HN4_A1232FerOrigId ;
   private boolean[] P01HN4_n1232FerOrigId ;
   private String[] P01HN4_A1228FerDescrip ;
   private String[] P01HN4_A1233FeriadoTipo ;
   private String[] P01HN4_A1223FerId ;
   private String[] P01HN5_A1232FerOrigId ;
   private boolean[] P01HN5_n1232FerOrigId ;
   private short[] P01HN5_A46PaiCod ;
   private String[] P01HN5_A1234FeriadoConvenio ;
   private boolean[] P01HN5_n1234FeriadoConvenio ;
   private String[] P01HN5_A1230FerReligId ;
   private boolean[] P01HN5_n1230FerReligId ;
   private String[] P01HN5_A1228FerDescrip ;
   private String[] P01HN5_A1233FeriadoTipo ;
   private String[] P01HN5_A1223FerId ;
   private String[] P01HN6_A1234FeriadoConvenio ;
   private boolean[] P01HN6_n1234FeriadoConvenio ;
   private short[] P01HN6_A46PaiCod ;
   private String[] P01HN6_A1232FerOrigId ;
   private boolean[] P01HN6_n1232FerOrigId ;
   private String[] P01HN6_A1230FerReligId ;
   private boolean[] P01HN6_n1230FerReligId ;
   private String[] P01HN6_A1228FerDescrip ;
   private String[] P01HN6_A1233FeriadoTipo ;
   private String[] P01HN6_A1223FerId ;
   private GXSimpleCollection<String> AV13TFFerId_Sels ;
   private GXSimpleCollection<String> AV15TFFeriadoTipo_Sels ;
   private GXSimpleCollection<String> AV25TFFerReligId_Sels ;
   private GXSimpleCollection<String> AV28TFFerOrigId_Sels ;
   private GXSimpleCollection<String> AV31TFFeriadoConvenio_Sels ;
   private GXSimpleCollection<String> AV60Feriadowwds_2_tfferid_sels ;
   private GXSimpleCollection<String> AV61Feriadowwds_3_tfferiadotipo_sels ;
   private GXSimpleCollection<String> AV65Feriadowwds_7_tfferreligid_sels ;
   private GXSimpleCollection<String> AV67Feriadowwds_9_tfferorigid_sels ;
   private GXSimpleCollection<String> AV69Feriadowwds_11_tfferiadoconvenio_sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV36OptionsDesc ;
   private GXSimpleCollection<String> AV37OptionIndexes ;
   private GXSimpleCollection<String> AV22TFFerDescrip_Sels ;
   private GXSimpleCollection<String> AV63Feriadowwds_5_tfferdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
}

final  class feriadowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV60Feriadowwds_2_tfferid_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV61Feriadowwds_3_tfferiadotipo_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV63Feriadowwds_5_tfferdescrip_sels ,
                                          String A1230FerReligId ,
                                          GXSimpleCollection<String> AV65Feriadowwds_7_tfferreligid_sels ,
                                          String A1232FerOrigId ,
                                          GXSimpleCollection<String> AV67Feriadowwds_9_tfferorigid_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                          int AV60Feriadowwds_2_tfferid_sels_size ,
                                          String AV59Feriadowwds_1_tfferid ,
                                          int AV61Feriadowwds_3_tfferiadotipo_sels_size ,
                                          int AV63Feriadowwds_5_tfferdescrip_sels_size ,
                                          String AV62Feriadowwds_4_tfferdescrip ,
                                          int AV65Feriadowwds_7_tfferreligid_sels_size ,
                                          String AV64Feriadowwds_6_tfferreligid ,
                                          int AV67Feriadowwds_9_tfferorigid_sels_size ,
                                          String AV66Feriadowwds_8_tfferorigid ,
                                          int AV69Feriadowwds_11_tfferiadoconvenio_sels_size ,
                                          String AV68Feriadowwds_10_tfferiadoconvenio ,
                                          short AV53PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT FerId, PaiCod, FeriadoConvenio, FerOrigId, FerReligId, FerDescrip, FeriadoTipo FROM feriado" ;
      if ( ( AV60Feriadowwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Feriadowwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerId) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV60Feriadowwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Feriadowwds_2_tfferid_sels, "FerId IN (", ")")+")");
      }
      if ( AV61Feriadowwds_3_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Feriadowwds_3_tfferiadotipo_sels, "FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV63Feriadowwds_5_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Feriadowwds_4_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV63Feriadowwds_5_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Feriadowwds_5_tfferdescrip_sels, "FerDescrip IN (", ")")+")");
      }
      if ( ( AV65Feriadowwds_7_tfferreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Feriadowwds_6_tfferreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerReligId) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV65Feriadowwds_7_tfferreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Feriadowwds_7_tfferreligid_sels, "FerReligId IN (", ")")+")");
      }
      if ( ( AV67Feriadowwds_9_tfferorigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Feriadowwds_8_tfferorigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerOrigId) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV67Feriadowwds_9_tfferorigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Feriadowwds_9_tfferorigid_sels, "FerOrigId IN (", ")")+")");
      }
      if ( ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Feriadowwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Feriadowwds_11_tfferiadoconvenio_sels, "FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV53PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY FerId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01HN3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV60Feriadowwds_2_tfferid_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV61Feriadowwds_3_tfferiadotipo_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV63Feriadowwds_5_tfferdescrip_sels ,
                                          String A1230FerReligId ,
                                          GXSimpleCollection<String> AV65Feriadowwds_7_tfferreligid_sels ,
                                          String A1232FerOrigId ,
                                          GXSimpleCollection<String> AV67Feriadowwds_9_tfferorigid_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                          int AV60Feriadowwds_2_tfferid_sels_size ,
                                          String AV59Feriadowwds_1_tfferid ,
                                          int AV61Feriadowwds_3_tfferiadotipo_sels_size ,
                                          int AV63Feriadowwds_5_tfferdescrip_sels_size ,
                                          String AV62Feriadowwds_4_tfferdescrip ,
                                          int AV65Feriadowwds_7_tfferreligid_sels_size ,
                                          String AV64Feriadowwds_6_tfferreligid ,
                                          int AV67Feriadowwds_9_tfferorigid_sels_size ,
                                          String AV66Feriadowwds_8_tfferorigid ,
                                          int AV69Feriadowwds_11_tfferiadoconvenio_sels_size ,
                                          String AV68Feriadowwds_10_tfferiadoconvenio ,
                                          short AV53PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT FerDescrip, PaiCod, FeriadoConvenio, FerOrigId, FerReligId, FeriadoTipo, FerId FROM feriado" ;
      if ( ( AV60Feriadowwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Feriadowwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerId) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV60Feriadowwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Feriadowwds_2_tfferid_sels, "FerId IN (", ")")+")");
      }
      if ( AV61Feriadowwds_3_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Feriadowwds_3_tfferiadotipo_sels, "FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV63Feriadowwds_5_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Feriadowwds_4_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV63Feriadowwds_5_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Feriadowwds_5_tfferdescrip_sels, "FerDescrip IN (", ")")+")");
      }
      if ( ( AV65Feriadowwds_7_tfferreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Feriadowwds_6_tfferreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerReligId) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV65Feriadowwds_7_tfferreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Feriadowwds_7_tfferreligid_sels, "FerReligId IN (", ")")+")");
      }
      if ( ( AV67Feriadowwds_9_tfferorigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Feriadowwds_8_tfferorigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerOrigId) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV67Feriadowwds_9_tfferorigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Feriadowwds_9_tfferorigid_sels, "FerOrigId IN (", ")")+")");
      }
      if ( ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Feriadowwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Feriadowwds_11_tfferiadoconvenio_sels, "FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV53PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY FerDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01HN4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV60Feriadowwds_2_tfferid_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV61Feriadowwds_3_tfferiadotipo_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV63Feriadowwds_5_tfferdescrip_sels ,
                                          String A1230FerReligId ,
                                          GXSimpleCollection<String> AV65Feriadowwds_7_tfferreligid_sels ,
                                          String A1232FerOrigId ,
                                          GXSimpleCollection<String> AV67Feriadowwds_9_tfferorigid_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                          int AV60Feriadowwds_2_tfferid_sels_size ,
                                          String AV59Feriadowwds_1_tfferid ,
                                          int AV61Feriadowwds_3_tfferiadotipo_sels_size ,
                                          int AV63Feriadowwds_5_tfferdescrip_sels_size ,
                                          String AV62Feriadowwds_4_tfferdescrip ,
                                          int AV65Feriadowwds_7_tfferreligid_sels_size ,
                                          String AV64Feriadowwds_6_tfferreligid ,
                                          int AV67Feriadowwds_9_tfferorigid_sels_size ,
                                          String AV66Feriadowwds_8_tfferorigid ,
                                          int AV69Feriadowwds_11_tfferiadoconvenio_sels_size ,
                                          String AV68Feriadowwds_10_tfferiadoconvenio ,
                                          short AV53PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT FerReligId, PaiCod, FeriadoConvenio, FerOrigId, FerDescrip, FeriadoTipo, FerId FROM feriado" ;
      if ( ( AV60Feriadowwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Feriadowwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerId) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV60Feriadowwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Feriadowwds_2_tfferid_sels, "FerId IN (", ")")+")");
      }
      if ( AV61Feriadowwds_3_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Feriadowwds_3_tfferiadotipo_sels, "FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV63Feriadowwds_5_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Feriadowwds_4_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV63Feriadowwds_5_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Feriadowwds_5_tfferdescrip_sels, "FerDescrip IN (", ")")+")");
      }
      if ( ( AV65Feriadowwds_7_tfferreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Feriadowwds_6_tfferreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerReligId) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV65Feriadowwds_7_tfferreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Feriadowwds_7_tfferreligid_sels, "FerReligId IN (", ")")+")");
      }
      if ( ( AV67Feriadowwds_9_tfferorigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Feriadowwds_8_tfferorigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerOrigId) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV67Feriadowwds_9_tfferorigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Feriadowwds_9_tfferorigid_sels, "FerOrigId IN (", ")")+")");
      }
      if ( ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Feriadowwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Feriadowwds_11_tfferiadoconvenio_sels, "FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV53PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY FerReligId" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P01HN5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV60Feriadowwds_2_tfferid_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV61Feriadowwds_3_tfferiadotipo_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV63Feriadowwds_5_tfferdescrip_sels ,
                                          String A1230FerReligId ,
                                          GXSimpleCollection<String> AV65Feriadowwds_7_tfferreligid_sels ,
                                          String A1232FerOrigId ,
                                          GXSimpleCollection<String> AV67Feriadowwds_9_tfferorigid_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                          int AV60Feriadowwds_2_tfferid_sels_size ,
                                          String AV59Feriadowwds_1_tfferid ,
                                          int AV61Feriadowwds_3_tfferiadotipo_sels_size ,
                                          int AV63Feriadowwds_5_tfferdescrip_sels_size ,
                                          String AV62Feriadowwds_4_tfferdescrip ,
                                          int AV65Feriadowwds_7_tfferreligid_sels_size ,
                                          String AV64Feriadowwds_6_tfferreligid ,
                                          int AV67Feriadowwds_9_tfferorigid_sels_size ,
                                          String AV66Feriadowwds_8_tfferorigid ,
                                          int AV69Feriadowwds_11_tfferiadoconvenio_sels_size ,
                                          String AV68Feriadowwds_10_tfferiadoconvenio ,
                                          short AV53PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[6];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT FerOrigId, PaiCod, FeriadoConvenio, FerReligId, FerDescrip, FeriadoTipo, FerId FROM feriado" ;
      if ( ( AV60Feriadowwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Feriadowwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerId) like LOWER(?))");
      }
      else
      {
         GXv_int17[0] = (byte)(1) ;
      }
      if ( AV60Feriadowwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Feriadowwds_2_tfferid_sels, "FerId IN (", ")")+")");
      }
      if ( AV61Feriadowwds_3_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Feriadowwds_3_tfferiadotipo_sels, "FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV63Feriadowwds_5_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Feriadowwds_4_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV63Feriadowwds_5_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Feriadowwds_5_tfferdescrip_sels, "FerDescrip IN (", ")")+")");
      }
      if ( ( AV65Feriadowwds_7_tfferreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Feriadowwds_6_tfferreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerReligId) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV65Feriadowwds_7_tfferreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Feriadowwds_7_tfferreligid_sels, "FerReligId IN (", ")")+")");
      }
      if ( ( AV67Feriadowwds_9_tfferorigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Feriadowwds_8_tfferorigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerOrigId) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV67Feriadowwds_9_tfferorigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Feriadowwds_9_tfferorigid_sels, "FerOrigId IN (", ")")+")");
      }
      if ( ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Feriadowwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Feriadowwds_11_tfferiadoconvenio_sels, "FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV53PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY FerOrigId" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P01HN6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV60Feriadowwds_2_tfferid_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV61Feriadowwds_3_tfferiadotipo_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV63Feriadowwds_5_tfferdescrip_sels ,
                                          String A1230FerReligId ,
                                          GXSimpleCollection<String> AV65Feriadowwds_7_tfferreligid_sels ,
                                          String A1232FerOrigId ,
                                          GXSimpleCollection<String> AV67Feriadowwds_9_tfferorigid_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV69Feriadowwds_11_tfferiadoconvenio_sels ,
                                          int AV60Feriadowwds_2_tfferid_sels_size ,
                                          String AV59Feriadowwds_1_tfferid ,
                                          int AV61Feriadowwds_3_tfferiadotipo_sels_size ,
                                          int AV63Feriadowwds_5_tfferdescrip_sels_size ,
                                          String AV62Feriadowwds_4_tfferdescrip ,
                                          int AV65Feriadowwds_7_tfferreligid_sels_size ,
                                          String AV64Feriadowwds_6_tfferreligid ,
                                          int AV67Feriadowwds_9_tfferorigid_sels_size ,
                                          String AV66Feriadowwds_8_tfferorigid ,
                                          int AV69Feriadowwds_11_tfferiadoconvenio_sels_size ,
                                          String AV68Feriadowwds_10_tfferiadoconvenio ,
                                          short AV53PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[6];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT FeriadoConvenio, PaiCod, FerOrigId, FerReligId, FerDescrip, FeriadoTipo, FerId FROM feriado" ;
      if ( ( AV60Feriadowwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Feriadowwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerId) like LOWER(?))");
      }
      else
      {
         GXv_int20[0] = (byte)(1) ;
      }
      if ( AV60Feriadowwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Feriadowwds_2_tfferid_sels, "FerId IN (", ")")+")");
      }
      if ( AV61Feriadowwds_3_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Feriadowwds_3_tfferiadotipo_sels, "FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV63Feriadowwds_5_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Feriadowwds_4_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[1] = (byte)(1) ;
      }
      if ( AV63Feriadowwds_5_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Feriadowwds_5_tfferdescrip_sels, "FerDescrip IN (", ")")+")");
      }
      if ( ( AV65Feriadowwds_7_tfferreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Feriadowwds_6_tfferreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerReligId) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV65Feriadowwds_7_tfferreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Feriadowwds_7_tfferreligid_sels, "FerReligId IN (", ")")+")");
      }
      if ( ( AV67Feriadowwds_9_tfferorigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Feriadowwds_8_tfferorigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerOrigId) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV67Feriadowwds_9_tfferorigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Feriadowwds_9_tfferorigid_sels, "FerOrigId IN (", ")")+")");
      }
      if ( ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Feriadowwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV69Feriadowwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Feriadowwds_11_tfferiadoconvenio_sels, "FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV53PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY FeriadoConvenio" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
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
                  return conditional_P01HN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() );
            case 1 :
                  return conditional_P01HN3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() );
            case 2 :
                  return conditional_P01HN4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() );
            case 3 :
                  return conditional_P01HN5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() );
            case 4 :
                  return conditional_P01HN6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HN3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HN4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HN5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HN6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getString(7, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((String[]) buf[9])[0] = rslt.getString(7, 40);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((String[]) buf[9])[0] = rslt.getString(7, 40);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((String[]) buf[9])[0] = rslt.getString(7, 40);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((String[]) buf[9])[0] = rslt.getString(7, 40);
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
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
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
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
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
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
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


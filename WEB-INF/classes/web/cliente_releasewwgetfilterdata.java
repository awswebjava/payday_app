package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cliente_releasewwgetfilterdata extends GXProcedure
{
   public cliente_releasewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_releasewwgetfilterdata.class ), "" );
   }

   public cliente_releasewwgetfilterdata( int remoteHandle ,
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
      cliente_releasewwgetfilterdata.this.aP5 = new String[] {""};
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
      cliente_releasewwgetfilterdata.this.AV29DDOName = aP0;
      cliente_releasewwgetfilterdata.this.AV30SearchTxt = aP1;
      cliente_releasewwgetfilterdata.this.AV31SearchTxtTo = aP2;
      cliente_releasewwgetfilterdata.this.aP3 = aP3;
      cliente_releasewwgetfilterdata.this.aP4 = aP4;
      cliente_releasewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      cliente_releasewwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      cliente_releasewwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Release", GXv_boolean6) ;
      cliente_releasewwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CLIRELNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADCLIRELNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CLIRELEASEDES") == 0 )
         {
            /* Execute user subroutine: 'LOADCLIRELEASEDESOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CLIREOBS") == 0 )
         {
            /* Execute user subroutine: 'LOADCLIREOBSOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV32OptionsJson = AV19Options.toJSonString(false) ;
      AV33OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV22OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("Cliente_ReleaseWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Cliente_ReleaseWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("Cliente_ReleaseWWGridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELNOMBRE") == 0 )
         {
            AV43TFCliRelNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELNOMBRE_SEL") == 0 )
         {
            AV42TFCliRelNombre_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFCliRelNombre_Sels.fromJSonString(AV42TFCliRelNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELEASEDES") == 0 )
         {
            AV39TFCliReleaseDes = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELEASEDES_SEL") == 0 )
         {
            AV38TFCliReleaseDes_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFCliReleaseDes_Sels.fromJSonString(AV38TFCliReleaseDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELEASE") == 0 )
         {
            AV11TFCliRelease = localUtil.ctot( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV12TFCliRelease_To = localUtil.ctot( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIREHABILITADO_SEL") == 0 )
         {
            AV13TFCliReHabilitado_Sel = (byte)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIREOBS") == 0 )
         {
            AV15TFCliReObs = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIREOBS_SEL") == 0 )
         {
            AV14TFCliReObs_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFCliReObs_Sels.fromJSonString(AV14TFCliReObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCLIRELNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV43TFCliRelNombre = AV30SearchTxt ;
      AV44TFCliRelNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Cliente_releasewwds_1_tfclirelnombre = AV43TFCliRelNombre ;
      AV50Cliente_releasewwds_2_tfclirelnombre_sels = AV44TFCliRelNombre_Sels ;
      AV51Cliente_releasewwds_3_tfclireleasedes = AV39TFCliReleaseDes ;
      AV52Cliente_releasewwds_4_tfclireleasedes_sels = AV40TFCliReleaseDes_Sels ;
      AV53Cliente_releasewwds_5_tfclirelease = AV11TFCliRelease ;
      AV54Cliente_releasewwds_6_tfclirelease_to = AV12TFCliRelease_To ;
      AV55Cliente_releasewwds_7_tfclirehabilitado_sel = AV13TFCliReHabilitado_Sel ;
      AV56Cliente_releasewwds_8_tfclireobs = AV15TFCliReObs ;
      AV57Cliente_releasewwds_9_tfclireobs_sels = AV16TFCliReObs_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1973CliRelNombre ,
                                           AV50Cliente_releasewwds_2_tfclirelnombre_sels ,
                                           A1879CliReleaseDes ,
                                           AV52Cliente_releasewwds_4_tfclireleasedes_sels ,
                                           A1878CliReObs ,
                                           AV57Cliente_releasewwds_9_tfclireobs_sels ,
                                           Integer.valueOf(AV50Cliente_releasewwds_2_tfclirelnombre_sels.size()) ,
                                           AV49Cliente_releasewwds_1_tfclirelnombre ,
                                           Integer.valueOf(AV52Cliente_releasewwds_4_tfclireleasedes_sels.size()) ,
                                           AV51Cliente_releasewwds_3_tfclireleasedes ,
                                           AV53Cliente_releasewwds_5_tfclirelease ,
                                           AV54Cliente_releasewwds_6_tfclirelease_to ,
                                           Byte.valueOf(AV55Cliente_releasewwds_7_tfclirehabilitado_sel) ,
                                           Integer.valueOf(AV57Cliente_releasewwds_9_tfclireobs_sels.size()) ,
                                           AV56Cliente_releasewwds_8_tfclireobs ,
                                           A1876CliRelease ,
                                           Boolean.valueOf(A1877CliReHabilitado) ,
                                           Integer.valueOf(AV37CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV49Cliente_releasewwds_1_tfclirelnombre = GXutil.concat( GXutil.rtrim( AV49Cliente_releasewwds_1_tfclirelnombre), "%", "") ;
      lV51Cliente_releasewwds_3_tfclireleasedes = GXutil.concat( GXutil.rtrim( AV51Cliente_releasewwds_3_tfclireleasedes), "%", "") ;
      lV56Cliente_releasewwds_8_tfclireobs = GXutil.concat( GXutil.rtrim( AV56Cliente_releasewwds_8_tfclireobs), "%", "") ;
      /* Using cursor P01SE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV37CliCod), lV49Cliente_releasewwds_1_tfclirelnombre, lV51Cliente_releasewwds_3_tfclireleasedes, AV53Cliente_releasewwds_5_tfclirelease, AV54Cliente_releasewwds_6_tfclirelease_to, lV56Cliente_releasewwds_8_tfclireobs});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1SE2 = false ;
         A3CliCod = P01SE2_A3CliCod[0] ;
         A1973CliRelNombre = P01SE2_A1973CliRelNombre[0] ;
         A1878CliReObs = P01SE2_A1878CliReObs[0] ;
         A1877CliReHabilitado = P01SE2_A1877CliReHabilitado[0] ;
         A1876CliRelease = P01SE2_A1876CliRelease[0] ;
         A1879CliReleaseDes = P01SE2_A1879CliReleaseDes[0] ;
         A1885CliRelSec = P01SE2_A1885CliRelSec[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01SE2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01SE2_A1973CliRelNombre[0], A1973CliRelNombre) == 0 ) )
         {
            brk1SE2 = false ;
            A1885CliRelSec = P01SE2_A1885CliRelSec[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1SE2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1973CliRelNombre)==0) )
         {
            AV18Option = A1973CliRelNombre ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1SE2 )
         {
            brk1SE2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCLIRELEASEDESOPTIONS' Routine */
      returnInSub = false ;
      AV39TFCliReleaseDes = AV30SearchTxt ;
      AV40TFCliReleaseDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Cliente_releasewwds_1_tfclirelnombre = AV43TFCliRelNombre ;
      AV50Cliente_releasewwds_2_tfclirelnombre_sels = AV44TFCliRelNombre_Sels ;
      AV51Cliente_releasewwds_3_tfclireleasedes = AV39TFCliReleaseDes ;
      AV52Cliente_releasewwds_4_tfclireleasedes_sels = AV40TFCliReleaseDes_Sels ;
      AV53Cliente_releasewwds_5_tfclirelease = AV11TFCliRelease ;
      AV54Cliente_releasewwds_6_tfclirelease_to = AV12TFCliRelease_To ;
      AV55Cliente_releasewwds_7_tfclirehabilitado_sel = AV13TFCliReHabilitado_Sel ;
      AV56Cliente_releasewwds_8_tfclireobs = AV15TFCliReObs ;
      AV57Cliente_releasewwds_9_tfclireobs_sels = AV16TFCliReObs_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1973CliRelNombre ,
                                           AV50Cliente_releasewwds_2_tfclirelnombre_sels ,
                                           A1879CliReleaseDes ,
                                           AV52Cliente_releasewwds_4_tfclireleasedes_sels ,
                                           A1878CliReObs ,
                                           AV57Cliente_releasewwds_9_tfclireobs_sels ,
                                           Integer.valueOf(AV50Cliente_releasewwds_2_tfclirelnombre_sels.size()) ,
                                           AV49Cliente_releasewwds_1_tfclirelnombre ,
                                           Integer.valueOf(AV52Cliente_releasewwds_4_tfclireleasedes_sels.size()) ,
                                           AV51Cliente_releasewwds_3_tfclireleasedes ,
                                           AV53Cliente_releasewwds_5_tfclirelease ,
                                           AV54Cliente_releasewwds_6_tfclirelease_to ,
                                           Byte.valueOf(AV55Cliente_releasewwds_7_tfclirehabilitado_sel) ,
                                           Integer.valueOf(AV57Cliente_releasewwds_9_tfclireobs_sels.size()) ,
                                           AV56Cliente_releasewwds_8_tfclireobs ,
                                           A1876CliRelease ,
                                           Boolean.valueOf(A1877CliReHabilitado) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV49Cliente_releasewwds_1_tfclirelnombre = GXutil.concat( GXutil.rtrim( AV49Cliente_releasewwds_1_tfclirelnombre), "%", "") ;
      lV51Cliente_releasewwds_3_tfclireleasedes = GXutil.concat( GXutil.rtrim( AV51Cliente_releasewwds_3_tfclireleasedes), "%", "") ;
      lV56Cliente_releasewwds_8_tfclireobs = GXutil.concat( GXutil.rtrim( AV56Cliente_releasewwds_8_tfclireobs), "%", "") ;
      /* Using cursor P01SE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV37CliCod), lV49Cliente_releasewwds_1_tfclirelnombre, lV51Cliente_releasewwds_3_tfclireleasedes, AV53Cliente_releasewwds_5_tfclirelease, AV54Cliente_releasewwds_6_tfclirelease_to, lV56Cliente_releasewwds_8_tfclireobs});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1SE4 = false ;
         A3CliCod = P01SE3_A3CliCod[0] ;
         A1879CliReleaseDes = P01SE3_A1879CliReleaseDes[0] ;
         A1878CliReObs = P01SE3_A1878CliReObs[0] ;
         A1877CliReHabilitado = P01SE3_A1877CliReHabilitado[0] ;
         A1876CliRelease = P01SE3_A1876CliRelease[0] ;
         A1973CliRelNombre = P01SE3_A1973CliRelNombre[0] ;
         A1885CliRelSec = P01SE3_A1885CliRelSec[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01SE3_A1879CliReleaseDes[0], A1879CliReleaseDes) == 0 ) )
         {
            brk1SE4 = false ;
            A3CliCod = P01SE3_A3CliCod[0] ;
            A1885CliRelSec = P01SE3_A1885CliRelSec[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1SE4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1879CliReleaseDes)==0) )
         {
            AV18Option = A1879CliReleaseDes ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1SE4 )
         {
            brk1SE4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCLIREOBSOPTIONS' Routine */
      returnInSub = false ;
      AV15TFCliReObs = AV30SearchTxt ;
      AV16TFCliReObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Cliente_releasewwds_1_tfclirelnombre = AV43TFCliRelNombre ;
      AV50Cliente_releasewwds_2_tfclirelnombre_sels = AV44TFCliRelNombre_Sels ;
      AV51Cliente_releasewwds_3_tfclireleasedes = AV39TFCliReleaseDes ;
      AV52Cliente_releasewwds_4_tfclireleasedes_sels = AV40TFCliReleaseDes_Sels ;
      AV53Cliente_releasewwds_5_tfclirelease = AV11TFCliRelease ;
      AV54Cliente_releasewwds_6_tfclirelease_to = AV12TFCliRelease_To ;
      AV55Cliente_releasewwds_7_tfclirehabilitado_sel = AV13TFCliReHabilitado_Sel ;
      AV56Cliente_releasewwds_8_tfclireobs = AV15TFCliReObs ;
      AV57Cliente_releasewwds_9_tfclireobs_sels = AV16TFCliReObs_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1973CliRelNombre ,
                                           AV50Cliente_releasewwds_2_tfclirelnombre_sels ,
                                           A1879CliReleaseDes ,
                                           AV52Cliente_releasewwds_4_tfclireleasedes_sels ,
                                           A1878CliReObs ,
                                           AV57Cliente_releasewwds_9_tfclireobs_sels ,
                                           Integer.valueOf(AV50Cliente_releasewwds_2_tfclirelnombre_sels.size()) ,
                                           AV49Cliente_releasewwds_1_tfclirelnombre ,
                                           Integer.valueOf(AV52Cliente_releasewwds_4_tfclireleasedes_sels.size()) ,
                                           AV51Cliente_releasewwds_3_tfclireleasedes ,
                                           AV53Cliente_releasewwds_5_tfclirelease ,
                                           AV54Cliente_releasewwds_6_tfclirelease_to ,
                                           Byte.valueOf(AV55Cliente_releasewwds_7_tfclirehabilitado_sel) ,
                                           Integer.valueOf(AV57Cliente_releasewwds_9_tfclireobs_sels.size()) ,
                                           AV56Cliente_releasewwds_8_tfclireobs ,
                                           A1876CliRelease ,
                                           Boolean.valueOf(A1877CliReHabilitado) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV49Cliente_releasewwds_1_tfclirelnombre = GXutil.concat( GXutil.rtrim( AV49Cliente_releasewwds_1_tfclirelnombre), "%", "") ;
      lV51Cliente_releasewwds_3_tfclireleasedes = GXutil.concat( GXutil.rtrim( AV51Cliente_releasewwds_3_tfclireleasedes), "%", "") ;
      lV56Cliente_releasewwds_8_tfclireobs = GXutil.concat( GXutil.rtrim( AV56Cliente_releasewwds_8_tfclireobs), "%", "") ;
      /* Using cursor P01SE4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV37CliCod), lV49Cliente_releasewwds_1_tfclirelnombre, lV51Cliente_releasewwds_3_tfclireleasedes, AV53Cliente_releasewwds_5_tfclirelease, AV54Cliente_releasewwds_6_tfclirelease_to, lV56Cliente_releasewwds_8_tfclireobs});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1SE6 = false ;
         A3CliCod = P01SE4_A3CliCod[0] ;
         A1878CliReObs = P01SE4_A1878CliReObs[0] ;
         A1877CliReHabilitado = P01SE4_A1877CliReHabilitado[0] ;
         A1876CliRelease = P01SE4_A1876CliRelease[0] ;
         A1879CliReleaseDes = P01SE4_A1879CliReleaseDes[0] ;
         A1973CliRelNombre = P01SE4_A1973CliRelNombre[0] ;
         A1885CliRelSec = P01SE4_A1885CliRelSec[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01SE4_A1878CliReObs[0], A1878CliReObs) == 0 ) )
         {
            brk1SE6 = false ;
            A3CliCod = P01SE4_A3CliCod[0] ;
            A1885CliRelSec = P01SE4_A1885CliRelSec[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1SE6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1878CliReObs)==0) )
         {
            AV18Option = A1878CliReObs ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1SE6 )
         {
            brk1SE6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = cliente_releasewwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = cliente_releasewwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = cliente_releasewwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32OptionsJson = "" ;
      AV33OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43TFCliRelNombre = "" ;
      AV42TFCliRelNombre_SelsJson = "" ;
      AV44TFCliRelNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFCliReleaseDes = "" ;
      AV38TFCliReleaseDes_SelsJson = "" ;
      AV40TFCliReleaseDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV11TFCliRelease = GXutil.resetTime( GXutil.nullDate() );
      AV12TFCliRelease_To = GXutil.resetTime( GXutil.nullDate() );
      AV15TFCliReObs = "" ;
      AV14TFCliReObs_SelsJson = "" ;
      AV16TFCliReObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      A1973CliRelNombre = "" ;
      AV49Cliente_releasewwds_1_tfclirelnombre = "" ;
      AV50Cliente_releasewwds_2_tfclirelnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51Cliente_releasewwds_3_tfclireleasedes = "" ;
      AV52Cliente_releasewwds_4_tfclireleasedes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Cliente_releasewwds_5_tfclirelease = GXutil.resetTime( GXutil.nullDate() );
      AV54Cliente_releasewwds_6_tfclirelease_to = GXutil.resetTime( GXutil.nullDate() );
      AV56Cliente_releasewwds_8_tfclireobs = "" ;
      AV57Cliente_releasewwds_9_tfclireobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV49Cliente_releasewwds_1_tfclirelnombre = "" ;
      lV51Cliente_releasewwds_3_tfclireleasedes = "" ;
      lV56Cliente_releasewwds_8_tfclireobs = "" ;
      A1879CliReleaseDes = "" ;
      A1878CliReObs = "" ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      P01SE2_A3CliCod = new int[1] ;
      P01SE2_A1973CliRelNombre = new String[] {""} ;
      P01SE2_A1878CliReObs = new String[] {""} ;
      P01SE2_A1877CliReHabilitado = new boolean[] {false} ;
      P01SE2_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P01SE2_A1879CliReleaseDes = new String[] {""} ;
      P01SE2_A1885CliRelSec = new int[1] ;
      AV18Option = "" ;
      P01SE3_A3CliCod = new int[1] ;
      P01SE3_A1879CliReleaseDes = new String[] {""} ;
      P01SE3_A1878CliReObs = new String[] {""} ;
      P01SE3_A1877CliReHabilitado = new boolean[] {false} ;
      P01SE3_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P01SE3_A1973CliRelNombre = new String[] {""} ;
      P01SE3_A1885CliRelSec = new int[1] ;
      P01SE4_A3CliCod = new int[1] ;
      P01SE4_A1878CliReObs = new String[] {""} ;
      P01SE4_A1877CliReHabilitado = new boolean[] {false} ;
      P01SE4_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P01SE4_A1879CliReleaseDes = new String[] {""} ;
      P01SE4_A1973CliRelNombre = new String[] {""} ;
      P01SE4_A1885CliRelSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_releasewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01SE2_A3CliCod, P01SE2_A1973CliRelNombre, P01SE2_A1878CliReObs, P01SE2_A1877CliReHabilitado, P01SE2_A1876CliRelease, P01SE2_A1879CliReleaseDes, P01SE2_A1885CliRelSec
            }
            , new Object[] {
            P01SE3_A3CliCod, P01SE3_A1879CliReleaseDes, P01SE3_A1878CliReObs, P01SE3_A1877CliReHabilitado, P01SE3_A1876CliRelease, P01SE3_A1973CliRelNombre, P01SE3_A1885CliRelSec
            }
            , new Object[] {
            P01SE4_A3CliCod, P01SE4_A1878CliReObs, P01SE4_A1877CliReHabilitado, P01SE4_A1876CliRelease, P01SE4_A1879CliReleaseDes, P01SE4_A1973CliRelNombre, P01SE4_A1885CliRelSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13TFCliReHabilitado_Sel ;
   private byte AV55Cliente_releasewwds_7_tfclirehabilitado_sel ;
   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV47GXV1 ;
   private int AV50Cliente_releasewwds_2_tfclirelnombre_sels_size ;
   private int AV52Cliente_releasewwds_4_tfclireleasedes_sels_size ;
   private int AV57Cliente_releasewwds_9_tfclireobs_sels_size ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private long AV23count ;
   private String scmdbuf ;
   private java.util.Date AV11TFCliRelease ;
   private java.util.Date AV12TFCliRelease_To ;
   private java.util.Date AV53Cliente_releasewwds_5_tfclirelease ;
   private java.util.Date AV54Cliente_releasewwds_6_tfclirelease_to ;
   private java.util.Date A1876CliRelease ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1877CliReHabilitado ;
   private boolean brk1SE2 ;
   private boolean brk1SE4 ;
   private boolean brk1SE6 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV42TFCliRelNombre_SelsJson ;
   private String AV38TFCliReleaseDes_SelsJson ;
   private String AV14TFCliReObs_SelsJson ;
   private String A1878CliReObs ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV43TFCliRelNombre ;
   private String AV39TFCliReleaseDes ;
   private String AV15TFCliReObs ;
   private String AV41MenuOpcCod ;
   private String A1973CliRelNombre ;
   private String AV49Cliente_releasewwds_1_tfclirelnombre ;
   private String AV51Cliente_releasewwds_3_tfclireleasedes ;
   private String AV56Cliente_releasewwds_8_tfclireobs ;
   private String lV49Cliente_releasewwds_1_tfclirelnombre ;
   private String lV51Cliente_releasewwds_3_tfclireleasedes ;
   private String lV56Cliente_releasewwds_8_tfclireobs ;
   private String A1879CliReleaseDes ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01SE2_A3CliCod ;
   private String[] P01SE2_A1973CliRelNombre ;
   private String[] P01SE2_A1878CliReObs ;
   private boolean[] P01SE2_A1877CliReHabilitado ;
   private java.util.Date[] P01SE2_A1876CliRelease ;
   private String[] P01SE2_A1879CliReleaseDes ;
   private int[] P01SE2_A1885CliRelSec ;
   private int[] P01SE3_A3CliCod ;
   private String[] P01SE3_A1879CliReleaseDes ;
   private String[] P01SE3_A1878CliReObs ;
   private boolean[] P01SE3_A1877CliReHabilitado ;
   private java.util.Date[] P01SE3_A1876CliRelease ;
   private String[] P01SE3_A1973CliRelNombre ;
   private int[] P01SE3_A1885CliRelSec ;
   private int[] P01SE4_A3CliCod ;
   private String[] P01SE4_A1878CliReObs ;
   private boolean[] P01SE4_A1877CliReHabilitado ;
   private java.util.Date[] P01SE4_A1876CliRelease ;
   private String[] P01SE4_A1879CliReleaseDes ;
   private String[] P01SE4_A1973CliRelNombre ;
   private int[] P01SE4_A1885CliRelSec ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV44TFCliRelNombre_Sels ;
   private GXSimpleCollection<String> AV40TFCliReleaseDes_Sels ;
   private GXSimpleCollection<String> AV16TFCliReObs_Sels ;
   private GXSimpleCollection<String> AV50Cliente_releasewwds_2_tfclirelnombre_sels ;
   private GXSimpleCollection<String> AV52Cliente_releasewwds_4_tfclireleasedes_sels ;
   private GXSimpleCollection<String> AV57Cliente_releasewwds_9_tfclireobs_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class cliente_releasewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01SE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1973CliRelNombre ,
                                          GXSimpleCollection<String> AV50Cliente_releasewwds_2_tfclirelnombre_sels ,
                                          String A1879CliReleaseDes ,
                                          GXSimpleCollection<String> AV52Cliente_releasewwds_4_tfclireleasedes_sels ,
                                          String A1878CliReObs ,
                                          GXSimpleCollection<String> AV57Cliente_releasewwds_9_tfclireobs_sels ,
                                          int AV50Cliente_releasewwds_2_tfclirelnombre_sels_size ,
                                          String AV49Cliente_releasewwds_1_tfclirelnombre ,
                                          int AV52Cliente_releasewwds_4_tfclireleasedes_sels_size ,
                                          String AV51Cliente_releasewwds_3_tfclireleasedes ,
                                          java.util.Date AV53Cliente_releasewwds_5_tfclirelease ,
                                          java.util.Date AV54Cliente_releasewwds_6_tfclirelease_to ,
                                          byte AV55Cliente_releasewwds_7_tfclirehabilitado_sel ,
                                          int AV57Cliente_releasewwds_9_tfclireobs_sels_size ,
                                          String AV56Cliente_releasewwds_8_tfclireobs ,
                                          java.util.Date A1876CliRelease ,
                                          boolean A1877CliReHabilitado ,
                                          int AV37CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, CliRelNombre, CliReObs, CliReHabilitado, CliRelease, CliReleaseDes, CliRelSec FROM Cliente_Release" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV50Cliente_releasewwds_2_tfclirelnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Cliente_releasewwds_1_tfclirelnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliRelNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV50Cliente_releasewwds_2_tfclirelnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Cliente_releasewwds_2_tfclirelnombre_sels, "CliRelNombre IN (", ")")+")");
      }
      if ( ( AV52Cliente_releasewwds_4_tfclireleasedes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Cliente_releasewwds_3_tfclireleasedes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReleaseDes) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV52Cliente_releasewwds_4_tfclireleasedes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Cliente_releasewwds_4_tfclireleasedes_sels, "CliReleaseDes IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV53Cliente_releasewwds_5_tfclirelease) )
      {
         addWhere(sWhereString, "(CliRelease >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV54Cliente_releasewwds_6_tfclirelease_to) )
      {
         addWhere(sWhereString, "(CliRelease <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV55Cliente_releasewwds_7_tfclirehabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(CliReHabilitado = TRUE)");
      }
      if ( AV55Cliente_releasewwds_7_tfclirehabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(CliReHabilitado = FALSE)");
      }
      if ( ( AV57Cliente_releasewwds_9_tfclireobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Cliente_releasewwds_8_tfclireobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReObs) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV57Cliente_releasewwds_9_tfclireobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Cliente_releasewwds_9_tfclireobs_sels, "CliReObs IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliRelNombre" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01SE3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1973CliRelNombre ,
                                          GXSimpleCollection<String> AV50Cliente_releasewwds_2_tfclirelnombre_sels ,
                                          String A1879CliReleaseDes ,
                                          GXSimpleCollection<String> AV52Cliente_releasewwds_4_tfclireleasedes_sels ,
                                          String A1878CliReObs ,
                                          GXSimpleCollection<String> AV57Cliente_releasewwds_9_tfclireobs_sels ,
                                          int AV50Cliente_releasewwds_2_tfclirelnombre_sels_size ,
                                          String AV49Cliente_releasewwds_1_tfclirelnombre ,
                                          int AV52Cliente_releasewwds_4_tfclireleasedes_sels_size ,
                                          String AV51Cliente_releasewwds_3_tfclireleasedes ,
                                          java.util.Date AV53Cliente_releasewwds_5_tfclirelease ,
                                          java.util.Date AV54Cliente_releasewwds_6_tfclirelease_to ,
                                          byte AV55Cliente_releasewwds_7_tfclirehabilitado_sel ,
                                          int AV57Cliente_releasewwds_9_tfclireobs_sels_size ,
                                          String AV56Cliente_releasewwds_8_tfclireobs ,
                                          java.util.Date A1876CliRelease ,
                                          boolean A1877CliReHabilitado ,
                                          int A3CliCod ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CliReleaseDes, CliReObs, CliReHabilitado, CliRelease, CliRelNombre, CliRelSec FROM Cliente_Release" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV50Cliente_releasewwds_2_tfclirelnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Cliente_releasewwds_1_tfclirelnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliRelNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV50Cliente_releasewwds_2_tfclirelnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Cliente_releasewwds_2_tfclirelnombre_sels, "CliRelNombre IN (", ")")+")");
      }
      if ( ( AV52Cliente_releasewwds_4_tfclireleasedes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Cliente_releasewwds_3_tfclireleasedes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReleaseDes) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV52Cliente_releasewwds_4_tfclireleasedes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Cliente_releasewwds_4_tfclireleasedes_sels, "CliReleaseDes IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV53Cliente_releasewwds_5_tfclirelease) )
      {
         addWhere(sWhereString, "(CliRelease >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV54Cliente_releasewwds_6_tfclirelease_to) )
      {
         addWhere(sWhereString, "(CliRelease <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV55Cliente_releasewwds_7_tfclirehabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(CliReHabilitado = TRUE)");
      }
      if ( AV55Cliente_releasewwds_7_tfclirehabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(CliReHabilitado = FALSE)");
      }
      if ( ( AV57Cliente_releasewwds_9_tfclireobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Cliente_releasewwds_8_tfclireobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReObs) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV57Cliente_releasewwds_9_tfclireobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Cliente_releasewwds_9_tfclireobs_sels, "CliReObs IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliReleaseDes" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01SE4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1973CliRelNombre ,
                                          GXSimpleCollection<String> AV50Cliente_releasewwds_2_tfclirelnombre_sels ,
                                          String A1879CliReleaseDes ,
                                          GXSimpleCollection<String> AV52Cliente_releasewwds_4_tfclireleasedes_sels ,
                                          String A1878CliReObs ,
                                          GXSimpleCollection<String> AV57Cliente_releasewwds_9_tfclireobs_sels ,
                                          int AV50Cliente_releasewwds_2_tfclirelnombre_sels_size ,
                                          String AV49Cliente_releasewwds_1_tfclirelnombre ,
                                          int AV52Cliente_releasewwds_4_tfclireleasedes_sels_size ,
                                          String AV51Cliente_releasewwds_3_tfclireleasedes ,
                                          java.util.Date AV53Cliente_releasewwds_5_tfclirelease ,
                                          java.util.Date AV54Cliente_releasewwds_6_tfclirelease_to ,
                                          byte AV55Cliente_releasewwds_7_tfclirehabilitado_sel ,
                                          int AV57Cliente_releasewwds_9_tfclireobs_sels_size ,
                                          String AV56Cliente_releasewwds_8_tfclireobs ,
                                          java.util.Date A1876CliRelease ,
                                          boolean A1877CliReHabilitado ,
                                          int A3CliCod ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, CliReObs, CliReHabilitado, CliRelease, CliReleaseDes, CliRelNombre, CliRelSec FROM Cliente_Release" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV50Cliente_releasewwds_2_tfclirelnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Cliente_releasewwds_1_tfclirelnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliRelNombre) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV50Cliente_releasewwds_2_tfclirelnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Cliente_releasewwds_2_tfclirelnombre_sels, "CliRelNombre IN (", ")")+")");
      }
      if ( ( AV52Cliente_releasewwds_4_tfclireleasedes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Cliente_releasewwds_3_tfclireleasedes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReleaseDes) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV52Cliente_releasewwds_4_tfclireleasedes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Cliente_releasewwds_4_tfclireleasedes_sels, "CliReleaseDes IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV53Cliente_releasewwds_5_tfclirelease) )
      {
         addWhere(sWhereString, "(CliRelease >= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV54Cliente_releasewwds_6_tfclirelease_to) )
      {
         addWhere(sWhereString, "(CliRelease <= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV55Cliente_releasewwds_7_tfclirehabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(CliReHabilitado = TRUE)");
      }
      if ( AV55Cliente_releasewwds_7_tfclirehabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(CliReHabilitado = FALSE)");
      }
      if ( ( AV57Cliente_releasewwds_9_tfclireobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Cliente_releasewwds_8_tfclireobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReObs) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV57Cliente_releasewwds_9_tfclireobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Cliente_releasewwds_9_tfclireobs_sels, "CliReObs IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliReObs" ;
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
                  return conditional_P01SE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() );
            case 1 :
                  return conditional_P01SE3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() );
            case 2 :
                  return conditional_P01SE4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01SE3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01SE4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[10], false);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[10], false);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[10], false);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               return;
      }
   }

}


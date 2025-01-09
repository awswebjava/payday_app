package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variablevaloreswwgetfilterdata extends GXProcedure
{
   public variablevaloreswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variablevaloreswwgetfilterdata.class ), "" );
   }

   public variablevaloreswwgetfilterdata( int remoteHandle ,
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
      variablevaloreswwgetfilterdata.this.aP5 = new String[] {""};
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
      variablevaloreswwgetfilterdata.this.AV34DDOName = aP0;
      variablevaloreswwgetfilterdata.this.AV35SearchTxt = aP1;
      variablevaloreswwgetfilterdata.this.AV36SearchTxtTo = aP2;
      variablevaloreswwgetfilterdata.this.aP3 = aP3;
      variablevaloreswwgetfilterdata.this.aP4 = aP4;
      variablevaloreswwgetfilterdata.this.aP5 = aP5;
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
      variablevaloreswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV41EmpCod = GXt_int1 ;
      GXt_int3 = AV42CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      variablevaloreswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV42CliCod = GXt_int3 ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariableValores", GXv_boolean6) ;
      variablevaloreswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_OPECLIID") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECLIIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_OPECLIVALOR") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECLIVALOROPTIONS' */
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
      if ( GXutil.strcmp(AV29Session.getValue("VariableValoresWWGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "VariableValoresWWGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("VariableValoresWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID") == 0 )
         {
            AV12TFOpeCliId = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID_SEL") == 0 )
         {
            AV11TFOpeCliId_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFOpeCliId_Sels.fromJSonString(AV11TFOpeCliId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVIG") == 0 )
         {
            AV14TFOpeCliVig = localUtil.ctod( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV15TFOpeCliVig_To = localUtil.ctod( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVALOR") == 0 )
         {
            AV17TFOpeCliValor = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVALOR_SEL") == 0 )
         {
            AV16TFOpeCliValor_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFOpeCliValor_Sels.fromJSonString(AV16TFOpeCliValor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVPROPAGAR_SEL") == 0 )
         {
            AV19TFOpeCliVPropagar_Sel = (byte)(GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVRETRO") == 0 )
         {
            AV20TFOpeCliVRetro = localUtil.ctod( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV21TFOpeCliVRetro_To = localUtil.ctod( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV43MenuOpcCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADOPECLIIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFOpeCliId = AV35SearchTxt ;
      AV13TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Variablevaloreswwds_1_tfopecliid = AV12TFOpeCliId ;
      AV49Variablevaloreswwds_2_tfopecliid_sels = AV13TFOpeCliId_Sels ;
      AV50Variablevaloreswwds_3_tfopeclivig = AV14TFOpeCliVig ;
      AV51Variablevaloreswwds_4_tfopeclivig_to = AV15TFOpeCliVig_To ;
      AV52Variablevaloreswwds_5_tfopeclivalor = AV17TFOpeCliValor ;
      AV53Variablevaloreswwds_6_tfopeclivalor_sels = AV18TFOpeCliValor_Sels ;
      AV54Variablevaloreswwds_7_tfopeclivpropagar_sel = AV19TFOpeCliVPropagar_Sel ;
      AV55Variablevaloreswwds_8_tfopeclivretro = AV20TFOpeCliVRetro ;
      AV56Variablevaloreswwds_9_tfopeclivretro_to = AV21TFOpeCliVRetro_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV49Variablevaloreswwds_2_tfopecliid_sels ,
                                           A535OpeCliValor ,
                                           AV53Variablevaloreswwds_6_tfopeclivalor_sels ,
                                           Integer.valueOf(AV49Variablevaloreswwds_2_tfopecliid_sels.size()) ,
                                           AV48Variablevaloreswwds_1_tfopecliid ,
                                           AV50Variablevaloreswwds_3_tfopeclivig ,
                                           AV51Variablevaloreswwds_4_tfopeclivig_to ,
                                           Integer.valueOf(AV53Variablevaloreswwds_6_tfopeclivalor_sels.size()) ,
                                           AV52Variablevaloreswwds_5_tfopeclivalor ,
                                           Byte.valueOf(AV54Variablevaloreswwds_7_tfopeclivpropagar_sel) ,
                                           AV55Variablevaloreswwds_8_tfopeclivretro ,
                                           AV56Variablevaloreswwds_9_tfopeclivretro_to ,
                                           A754OpeCliVig ,
                                           Boolean.valueOf(A924OpeCliVPropagar) ,
                                           A1146OpeCliVRetro ,
                                           Integer.valueOf(AV42CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV48Variablevaloreswwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV48Variablevaloreswwds_1_tfopecliid), 40, "%") ;
      lV52Variablevaloreswwds_5_tfopeclivalor = GXutil.concat( GXutil.rtrim( AV52Variablevaloreswwds_5_tfopeclivalor), "%", "") ;
      /* Using cursor P01KD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV42CliCod), lV48Variablevaloreswwds_1_tfopecliid, AV50Variablevaloreswwds_3_tfopeclivig, AV51Variablevaloreswwds_4_tfopeclivig_to, lV52Variablevaloreswwds_5_tfopeclivalor, AV55Variablevaloreswwds_8_tfopeclivretro, AV56Variablevaloreswwds_9_tfopeclivretro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1KD2 = false ;
         A3CliCod = P01KD2_A3CliCod[0] ;
         A82OpeCliId = P01KD2_A82OpeCliId[0] ;
         A1146OpeCliVRetro = P01KD2_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = P01KD2_n1146OpeCliVRetro[0] ;
         A924OpeCliVPropagar = P01KD2_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = P01KD2_n924OpeCliVPropagar[0] ;
         A535OpeCliValor = P01KD2_A535OpeCliValor[0] ;
         A754OpeCliVig = P01KD2_A754OpeCliVig[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01KD2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01KD2_A82OpeCliId[0], A82OpeCliId) == 0 ) )
         {
            brk1KD2 = false ;
            A754OpeCliVig = P01KD2_A754OpeCliVig[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1KD2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A82OpeCliId)==0) )
         {
            AV23Option = A82OpeCliId ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KD2 )
         {
            brk1KD2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADOPECLIVALOROPTIONS' Routine */
      returnInSub = false ;
      AV17TFOpeCliValor = AV35SearchTxt ;
      AV18TFOpeCliValor_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Variablevaloreswwds_1_tfopecliid = AV12TFOpeCliId ;
      AV49Variablevaloreswwds_2_tfopecliid_sels = AV13TFOpeCliId_Sels ;
      AV50Variablevaloreswwds_3_tfopeclivig = AV14TFOpeCliVig ;
      AV51Variablevaloreswwds_4_tfopeclivig_to = AV15TFOpeCliVig_To ;
      AV52Variablevaloreswwds_5_tfopeclivalor = AV17TFOpeCliValor ;
      AV53Variablevaloreswwds_6_tfopeclivalor_sels = AV18TFOpeCliValor_Sels ;
      AV54Variablevaloreswwds_7_tfopeclivpropagar_sel = AV19TFOpeCliVPropagar_Sel ;
      AV55Variablevaloreswwds_8_tfopeclivretro = AV20TFOpeCliVRetro ;
      AV56Variablevaloreswwds_9_tfopeclivretro_to = AV21TFOpeCliVRetro_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV49Variablevaloreswwds_2_tfopecliid_sels ,
                                           A535OpeCliValor ,
                                           AV53Variablevaloreswwds_6_tfopeclivalor_sels ,
                                           Integer.valueOf(AV49Variablevaloreswwds_2_tfopecliid_sels.size()) ,
                                           AV48Variablevaloreswwds_1_tfopecliid ,
                                           AV50Variablevaloreswwds_3_tfopeclivig ,
                                           AV51Variablevaloreswwds_4_tfopeclivig_to ,
                                           Integer.valueOf(AV53Variablevaloreswwds_6_tfopeclivalor_sels.size()) ,
                                           AV52Variablevaloreswwds_5_tfopeclivalor ,
                                           Byte.valueOf(AV54Variablevaloreswwds_7_tfopeclivpropagar_sel) ,
                                           AV55Variablevaloreswwds_8_tfopeclivretro ,
                                           AV56Variablevaloreswwds_9_tfopeclivretro_to ,
                                           A754OpeCliVig ,
                                           Boolean.valueOf(A924OpeCliVPropagar) ,
                                           A1146OpeCliVRetro ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV42CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV48Variablevaloreswwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV48Variablevaloreswwds_1_tfopecliid), 40, "%") ;
      lV52Variablevaloreswwds_5_tfopeclivalor = GXutil.concat( GXutil.rtrim( AV52Variablevaloreswwds_5_tfopeclivalor), "%", "") ;
      /* Using cursor P01KD3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV42CliCod), lV48Variablevaloreswwds_1_tfopecliid, AV50Variablevaloreswwds_3_tfopeclivig, AV51Variablevaloreswwds_4_tfopeclivig_to, lV52Variablevaloreswwds_5_tfopeclivalor, AV55Variablevaloreswwds_8_tfopeclivretro, AV56Variablevaloreswwds_9_tfopeclivretro_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1KD4 = false ;
         A3CliCod = P01KD3_A3CliCod[0] ;
         A535OpeCliValor = P01KD3_A535OpeCliValor[0] ;
         A1146OpeCliVRetro = P01KD3_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = P01KD3_n1146OpeCliVRetro[0] ;
         A924OpeCliVPropagar = P01KD3_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = P01KD3_n924OpeCliVPropagar[0] ;
         A754OpeCliVig = P01KD3_A754OpeCliVig[0] ;
         A82OpeCliId = P01KD3_A82OpeCliId[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01KD3_A535OpeCliValor[0], A535OpeCliValor) == 0 ) )
         {
            brk1KD4 = false ;
            A3CliCod = P01KD3_A3CliCod[0] ;
            A754OpeCliVig = P01KD3_A754OpeCliVig[0] ;
            A82OpeCliId = P01KD3_A82OpeCliId[0] ;
            AV28count = (long)(AV28count+1) ;
            brk1KD4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A535OpeCliValor)==0) )
         {
            AV23Option = A535OpeCliValor ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KD4 )
         {
            brk1KD4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = variablevaloreswwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = variablevaloreswwgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = variablevaloreswwgetfilterdata.this.AV39OptionIndexesJson;
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
      AV12TFOpeCliId = "" ;
      AV11TFOpeCliId_SelsJson = "" ;
      AV13TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFOpeCliVig = GXutil.nullDate() ;
      AV15TFOpeCliVig_To = GXutil.nullDate() ;
      AV17TFOpeCliValor = "" ;
      AV16TFOpeCliValor_SelsJson = "" ;
      AV18TFOpeCliValor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFOpeCliVRetro = GXutil.nullDate() ;
      AV21TFOpeCliVRetro_To = GXutil.nullDate() ;
      AV43MenuOpcCod = "" ;
      A82OpeCliId = "" ;
      AV48Variablevaloreswwds_1_tfopecliid = "" ;
      AV49Variablevaloreswwds_2_tfopecliid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Variablevaloreswwds_3_tfopeclivig = GXutil.nullDate() ;
      AV51Variablevaloreswwds_4_tfopeclivig_to = GXutil.nullDate() ;
      AV52Variablevaloreswwds_5_tfopeclivalor = "" ;
      AV53Variablevaloreswwds_6_tfopeclivalor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Variablevaloreswwds_8_tfopeclivretro = GXutil.nullDate() ;
      AV56Variablevaloreswwds_9_tfopeclivretro_to = GXutil.nullDate() ;
      scmdbuf = "" ;
      lV48Variablevaloreswwds_1_tfopecliid = "" ;
      lV52Variablevaloreswwds_5_tfopeclivalor = "" ;
      A535OpeCliValor = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      P01KD2_A3CliCod = new int[1] ;
      P01KD2_A82OpeCliId = new String[] {""} ;
      P01KD2_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P01KD2_n1146OpeCliVRetro = new boolean[] {false} ;
      P01KD2_A924OpeCliVPropagar = new boolean[] {false} ;
      P01KD2_n924OpeCliVPropagar = new boolean[] {false} ;
      P01KD2_A535OpeCliValor = new String[] {""} ;
      P01KD2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      AV23Option = "" ;
      P01KD3_A3CliCod = new int[1] ;
      P01KD3_A535OpeCliValor = new String[] {""} ;
      P01KD3_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P01KD3_n1146OpeCliVRetro = new boolean[] {false} ;
      P01KD3_A924OpeCliVPropagar = new boolean[] {false} ;
      P01KD3_n924OpeCliVPropagar = new boolean[] {false} ;
      P01KD3_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01KD3_A82OpeCliId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variablevaloreswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01KD2_A3CliCod, P01KD2_A82OpeCliId, P01KD2_A1146OpeCliVRetro, P01KD2_n1146OpeCliVRetro, P01KD2_A924OpeCliVPropagar, P01KD2_n924OpeCliVPropagar, P01KD2_A535OpeCliValor, P01KD2_A754OpeCliVig
            }
            , new Object[] {
            P01KD3_A3CliCod, P01KD3_A535OpeCliValor, P01KD3_A1146OpeCliVRetro, P01KD3_n1146OpeCliVRetro, P01KD3_A924OpeCliVPropagar, P01KD3_n924OpeCliVPropagar, P01KD3_A754OpeCliVig, P01KD3_A82OpeCliId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV19TFOpeCliVPropagar_Sel ;
   private byte AV54Variablevaloreswwds_7_tfopeclivpropagar_sel ;
   private short AV41EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV42CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV46GXV1 ;
   private int AV49Variablevaloreswwds_2_tfopecliid_sels_size ;
   private int AV53Variablevaloreswwds_6_tfopeclivalor_sels_size ;
   private int A3CliCod ;
   private long AV28count ;
   private String AV12TFOpeCliId ;
   private String A82OpeCliId ;
   private String AV48Variablevaloreswwds_1_tfopecliid ;
   private String scmdbuf ;
   private String lV48Variablevaloreswwds_1_tfopecliid ;
   private java.util.Date AV14TFOpeCliVig ;
   private java.util.Date AV15TFOpeCliVig_To ;
   private java.util.Date AV20TFOpeCliVRetro ;
   private java.util.Date AV21TFOpeCliVRetro_To ;
   private java.util.Date AV50Variablevaloreswwds_3_tfopeclivig ;
   private java.util.Date AV51Variablevaloreswwds_4_tfopeclivig_to ;
   private java.util.Date AV55Variablevaloreswwds_8_tfopeclivretro ;
   private java.util.Date AV56Variablevaloreswwds_9_tfopeclivretro_to ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A924OpeCliVPropagar ;
   private boolean brk1KD2 ;
   private boolean n1146OpeCliVRetro ;
   private boolean n924OpeCliVPropagar ;
   private boolean brk1KD4 ;
   private String AV37OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV39OptionIndexesJson ;
   private String AV11TFOpeCliId_SelsJson ;
   private String AV16TFOpeCliValor_SelsJson ;
   private String A535OpeCliValor ;
   private String AV34DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV17TFOpeCliValor ;
   private String AV43MenuOpcCod ;
   private String AV52Variablevaloreswwds_5_tfopeclivalor ;
   private String lV52Variablevaloreswwds_5_tfopeclivalor ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01KD2_A3CliCod ;
   private String[] P01KD2_A82OpeCliId ;
   private java.util.Date[] P01KD2_A1146OpeCliVRetro ;
   private boolean[] P01KD2_n1146OpeCliVRetro ;
   private boolean[] P01KD2_A924OpeCliVPropagar ;
   private boolean[] P01KD2_n924OpeCliVPropagar ;
   private String[] P01KD2_A535OpeCliValor ;
   private java.util.Date[] P01KD2_A754OpeCliVig ;
   private int[] P01KD3_A3CliCod ;
   private String[] P01KD3_A535OpeCliValor ;
   private java.util.Date[] P01KD3_A1146OpeCliVRetro ;
   private boolean[] P01KD3_n1146OpeCliVRetro ;
   private boolean[] P01KD3_A924OpeCliVPropagar ;
   private boolean[] P01KD3_n924OpeCliVPropagar ;
   private java.util.Date[] P01KD3_A754OpeCliVig ;
   private String[] P01KD3_A82OpeCliId ;
   private GXSimpleCollection<String> AV13TFOpeCliId_Sels ;
   private GXSimpleCollection<String> AV49Variablevaloreswwds_2_tfopecliid_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV18TFOpeCliValor_Sels ;
   private GXSimpleCollection<String> AV53Variablevaloreswwds_6_tfopeclivalor_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class variablevaloreswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV49Variablevaloreswwds_2_tfopecliid_sels ,
                                          String A535OpeCliValor ,
                                          GXSimpleCollection<String> AV53Variablevaloreswwds_6_tfopeclivalor_sels ,
                                          int AV49Variablevaloreswwds_2_tfopecliid_sels_size ,
                                          String AV48Variablevaloreswwds_1_tfopecliid ,
                                          java.util.Date AV50Variablevaloreswwds_3_tfopeclivig ,
                                          java.util.Date AV51Variablevaloreswwds_4_tfopeclivig_to ,
                                          int AV53Variablevaloreswwds_6_tfopeclivalor_sels_size ,
                                          String AV52Variablevaloreswwds_5_tfopeclivalor ,
                                          byte AV54Variablevaloreswwds_7_tfopeclivpropagar_sel ,
                                          java.util.Date AV55Variablevaloreswwds_8_tfopeclivretro ,
                                          java.util.Date AV56Variablevaloreswwds_9_tfopeclivretro_to ,
                                          java.util.Date A754OpeCliVig ,
                                          boolean A924OpeCliVPropagar ,
                                          java.util.Date A1146OpeCliVRetro ,
                                          int AV42CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliId, OpeCliVRetro, OpeCliVPropagar, OpeCliValor, OpeCliVig FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV49Variablevaloreswwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Variablevaloreswwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV49Variablevaloreswwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Variablevaloreswwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50Variablevaloreswwds_3_tfopeclivig)) )
      {
         addWhere(sWhereString, "(OpeCliVig >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV51Variablevaloreswwds_4_tfopeclivig_to)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV53Variablevaloreswwds_6_tfopeclivalor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Variablevaloreswwds_5_tfopeclivalor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliValor) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV53Variablevaloreswwds_6_tfopeclivalor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Variablevaloreswwds_6_tfopeclivalor_sels, "OpeCliValor IN (", ")")+")");
      }
      if ( AV54Variablevaloreswwds_7_tfopeclivpropagar_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliVPropagar = TRUE)");
      }
      if ( AV54Variablevaloreswwds_7_tfopeclivpropagar_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliVPropagar = FALSE)");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55Variablevaloreswwds_8_tfopeclivretro)) )
      {
         addWhere(sWhereString, "(OpeCliVRetro >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56Variablevaloreswwds_9_tfopeclivretro_to)) )
      {
         addWhere(sWhereString, "(OpeCliVRetro <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01KD3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV49Variablevaloreswwds_2_tfopecliid_sels ,
                                          String A535OpeCliValor ,
                                          GXSimpleCollection<String> AV53Variablevaloreswwds_6_tfopeclivalor_sels ,
                                          int AV49Variablevaloreswwds_2_tfopecliid_sels_size ,
                                          String AV48Variablevaloreswwds_1_tfopecliid ,
                                          java.util.Date AV50Variablevaloreswwds_3_tfopeclivig ,
                                          java.util.Date AV51Variablevaloreswwds_4_tfopeclivig_to ,
                                          int AV53Variablevaloreswwds_6_tfopeclivalor_sels_size ,
                                          String AV52Variablevaloreswwds_5_tfopeclivalor ,
                                          byte AV54Variablevaloreswwds_7_tfopeclivpropagar_sel ,
                                          java.util.Date AV55Variablevaloreswwds_8_tfopeclivretro ,
                                          java.util.Date AV56Variablevaloreswwds_9_tfopeclivretro_to ,
                                          java.util.Date A754OpeCliVig ,
                                          boolean A924OpeCliVPropagar ,
                                          java.util.Date A1146OpeCliVRetro ,
                                          int A3CliCod ,
                                          int AV42CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[7];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliValor, OpeCliVRetro, OpeCliVPropagar, OpeCliVig, OpeCliId FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV49Variablevaloreswwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Variablevaloreswwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV49Variablevaloreswwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Variablevaloreswwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50Variablevaloreswwds_3_tfopeclivig)) )
      {
         addWhere(sWhereString, "(OpeCliVig >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV51Variablevaloreswwds_4_tfopeclivig_to)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV53Variablevaloreswwds_6_tfopeclivalor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Variablevaloreswwds_5_tfopeclivalor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliValor) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV53Variablevaloreswwds_6_tfopeclivalor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Variablevaloreswwds_6_tfopeclivalor_sels, "OpeCliValor IN (", ")")+")");
      }
      if ( AV54Variablevaloreswwds_7_tfopeclivpropagar_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliVPropagar = TRUE)");
      }
      if ( AV54Variablevaloreswwds_7_tfopeclivpropagar_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliVPropagar = FALSE)");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55Variablevaloreswwds_8_tfopeclivretro)) )
      {
         addWhere(sWhereString, "(OpeCliVRetro >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56Variablevaloreswwds_9_tfopeclivretro_to)) )
      {
         addWhere(sWhereString, "(OpeCliVRetro <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OpeCliValor" ;
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
                  return conditional_P01KD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Boolean) dynConstraints[14]).booleanValue() , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
            case 1 :
                  return conditional_P01KD3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Boolean) dynConstraints[14]).booleanValue() , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KD3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 40);
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
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
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
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               return;
      }
   }

}


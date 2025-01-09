package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicionafipwwgetfilterdata extends GXProcedure
{
   public condicionafipwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicionafipwwgetfilterdata.class ), "" );
   }

   public condicionafipwwgetfilterdata( int remoteHandle ,
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
      condicionafipwwgetfilterdata.this.aP5 = new String[] {""};
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
      condicionafipwwgetfilterdata.this.AV28DDOName = aP0;
      condicionafipwwgetfilterdata.this.AV29SearchTxt = aP1;
      condicionafipwwgetfilterdata.this.AV30SearchTxtTo = aP2;
      condicionafipwwgetfilterdata.this.aP3 = aP3;
      condicionafipwwgetfilterdata.this.aP4 = aP4;
      condicionafipwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      condicionafipwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      condicionafipwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondicionAFIP", GXv_boolean6) ;
      condicionafipwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_CONDIDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDIDESCRIOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("CondicionAFIPWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CondicionAFIPWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("CondicionAFIPWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICODIGO") == 0 )
         {
            AV11TFCondiCodigo = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCondiCodigo_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDIDESCRI") == 0 )
         {
            AV14TFCondiDescri = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDIDESCRI_SEL") == 0 )
         {
            AV13TFCondiDescri_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFCondiDescri_Sels.fromJSonString(AV13TFCondiDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV37MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONDIDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV14TFCondiDescri = AV29SearchTxt ;
      AV15TFCondiDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42Condicionafipwwds_1_tfcondicodigo = AV11TFCondiCodigo ;
      AV43Condicionafipwwds_2_tfcondicodigo_to = AV12TFCondiCodigo_To ;
      AV44Condicionafipwwds_3_tfcondidescri = AV14TFCondiDescri ;
      AV45Condicionafipwwds_4_tfcondidescri_sels = AV15TFCondiDescri_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A144CondiDescri ,
                                           AV45Condicionafipwwds_4_tfcondidescri_sels ,
                                           Short.valueOf(AV42Condicionafipwwds_1_tfcondicodigo) ,
                                           Short.valueOf(AV43Condicionafipwwds_2_tfcondicodigo_to) ,
                                           Integer.valueOf(AV45Condicionafipwwds_4_tfcondidescri_sels.size()) ,
                                           AV44Condicionafipwwds_3_tfcondidescri ,
                                           Short.valueOf(A17CondiCodigo) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT
                                           }
      });
      lV44Condicionafipwwds_3_tfcondidescri = GXutil.concat( GXutil.rtrim( AV44Condicionafipwwds_3_tfcondidescri), "%", "") ;
      /* Using cursor P01HV2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV42Condicionafipwwds_1_tfcondicodigo), Short.valueOf(AV43Condicionafipwwds_2_tfcondicodigo_to), lV44Condicionafipwwds_3_tfcondidescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1HV2 = false ;
         A144CondiDescri = P01HV2_A144CondiDescri[0] ;
         A17CondiCodigo = P01HV2_A17CondiCodigo[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01HV2_A144CondiDescri[0], A144CondiDescri) == 0 ) )
         {
            brk1HV2 = false ;
            A17CondiCodigo = P01HV2_A17CondiCodigo[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1HV2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A144CondiDescri)==0) )
         {
            AV17Option = A144CondiDescri ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HV2 )
         {
            brk1HV2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = condicionafipwwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = condicionafipwwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = condicionafipwwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFCondiDescri = "" ;
      AV13TFCondiDescri_SelsJson = "" ;
      AV15TFCondiDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37MenuOpcCod = "" ;
      A144CondiDescri = "" ;
      AV44Condicionafipwwds_3_tfcondidescri = "" ;
      AV45Condicionafipwwds_4_tfcondidescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Condicionafipwwds_3_tfcondidescri = "" ;
      P01HV2_A144CondiDescri = new String[] {""} ;
      P01HV2_A17CondiCodigo = new short[1] ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicionafipwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HV2_A144CondiDescri, P01HV2_A17CondiCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFCondiCodigo ;
   private short AV12TFCondiCodigo_To ;
   private short AV42Condicionafipwwds_1_tfcondicodigo ;
   private short AV43Condicionafipwwds_2_tfcondicodigo_to ;
   private short A17CondiCodigo ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV40GXV1 ;
   private int AV45Condicionafipwwds_4_tfcondidescri_sels_size ;
   private long AV22count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1HV2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFCondiDescri_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFCondiDescri ;
   private String AV37MenuOpcCod ;
   private String A144CondiDescri ;
   private String AV44Condicionafipwwds_3_tfcondidescri ;
   private String lV44Condicionafipwwds_3_tfcondidescri ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HV2_A144CondiDescri ;
   private short[] P01HV2_A17CondiCodigo ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFCondiDescri_Sels ;
   private GXSimpleCollection<String> AV45Condicionafipwwds_4_tfcondidescri_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class condicionafipwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A144CondiDescri ,
                                          GXSimpleCollection<String> AV45Condicionafipwwds_4_tfcondidescri_sels ,
                                          short AV42Condicionafipwwds_1_tfcondicodigo ,
                                          short AV43Condicionafipwwds_2_tfcondicodigo_to ,
                                          int AV45Condicionafipwwds_4_tfcondidescri_sels_size ,
                                          String AV44Condicionafipwwds_3_tfcondidescri ,
                                          short A17CondiCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CondiDescri, CondiCodigo FROM CondicionAFIP" ;
      if ( ! (0==AV42Condicionafipwwds_1_tfcondicodigo) )
      {
         addWhere(sWhereString, "(CondiCodigo >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV43Condicionafipwwds_2_tfcondicodigo_to) )
      {
         addWhere(sWhereString, "(CondiCodigo <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV45Condicionafipwwds_4_tfcondidescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Condicionafipwwds_3_tfcondidescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondiDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV45Condicionafipwwds_4_tfcondidescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Condicionafipwwds_4_tfcondidescri_sels, "CondiDescri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CondiDescri" ;
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
                  return conditional_P01HV2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
      }
   }

}


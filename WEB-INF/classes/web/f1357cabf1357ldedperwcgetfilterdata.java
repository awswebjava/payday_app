package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class f1357cabf1357ldedperwcgetfilterdata extends GXProcedure
{
   public f1357cabf1357ldedperwcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357cabf1357ldedperwcgetfilterdata.class ), "" );
   }

   public f1357cabf1357ldedperwcgetfilterdata( int remoteHandle ,
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
      f1357cabf1357ldedperwcgetfilterdata.this.aP5 = new String[] {""};
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
      f1357cabf1357ldedperwcgetfilterdata.this.AV16DDOName = aP0;
      f1357cabf1357ldedperwcgetfilterdata.this.AV14SearchTxt = aP1;
      f1357cabf1357ldedperwcgetfilterdata.this.AV15SearchTxtTo = aP2;
      f1357cabf1357ldedperwcgetfilterdata.this.aP3 = aP3;
      f1357cabf1357ldedperwcgetfilterdata.this.aP4 = aP4;
      f1357cabf1357ldedperwcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWF1357Cab", GXv_boolean2) ;
      f1357cabf1357ldedperwcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_LEGIDNOMAPE") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGIDNOMAPEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("F1357CabF1357LDedPerWCGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "F1357CabF1357LDedPerWCGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("F1357CabF1357LDedPerWCGridState"), null, null);
      }
      AV39GXV1 = 1 ;
      while ( AV39GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV39GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV12TFLegIdNomApe = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV11TFLegIdNomApe_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFLegIdNomApe_Sels.fromJSonString(AV11TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV32CliCod = (int)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV33EmpCod = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&F1357CTIPOPRE") == 0 )
         {
            AV36F1357CTipoPre = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&F1357CPER") == 0 )
         {
            AV34F1357CPer = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&F1357CSEC") == 0 )
         {
            AV35F1357CSec = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV39GXV1 = (int)(AV39GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV12TFLegIdNomApe = AV14SearchTxt ;
      AV13TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV13TFLegIdNomApe_Sels ,
                                           Integer.valueOf(AV13TFLegIdNomApe_Sels.size()) ,
                                           AV12TFLegIdNomApe ,
                                           Integer.valueOf(AV32CliCod) ,
                                           Short.valueOf(AV33EmpCod) ,
                                           Byte.valueOf(AV36F1357CTipoPre) ,
                                           AV34F1357CPer ,
                                           Byte.valueOf(AV35F1357CSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Byte.valueOf(A784F1357CTipoPre) ,
                                           A777F1357CPer ,
                                           Byte.valueOf(A778F1357CSec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      lV12TFLegIdNomApe = GXutil.concat( GXutil.rtrim( AV12TFLegIdNomApe), "%", "") ;
      /* Using cursor P00VC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV33EmpCod), Byte.valueOf(AV36F1357CTipoPre), AV34F1357CPer, Byte.valueOf(AV35F1357CSec), lV12TFLegIdNomApe});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00VC2_A6LegNumero[0] ;
         A250LegIdNomApe = P00VC2_A250LegIdNomApe[0] ;
         A778F1357CSec = P00VC2_A778F1357CSec[0] ;
         A777F1357CPer = P00VC2_A777F1357CPer[0] ;
         A784F1357CTipoPre = P00VC2_A784F1357CTipoPre[0] ;
         A1EmpCod = P00VC2_A1EmpCod[0] ;
         A3CliCod = P00VC2_A3CliCod[0] ;
         A862F1357LDPTipReg = P00VC2_A862F1357LDPTipReg[0] ;
         A250LegIdNomApe = P00VC2_A250LegIdNomApe[0] ;
         if ( ! (GXutil.strcmp("", A250LegIdNomApe)==0) )
         {
            AV18Option = A250LegIdNomApe ;
            AV17InsertIndex = 1 ;
            while ( ( AV17InsertIndex <= AV19Options.size() ) && ( GXutil.strcmp((String)AV19Options.elementAt(-1+AV17InsertIndex), AV18Option) < 0 ) )
            {
               AV17InsertIndex = (int)(AV17InsertIndex+1) ;
            }
            if ( ( AV17InsertIndex <= AV19Options.size() ) && ( GXutil.strcmp((String)AV19Options.elementAt(-1+AV17InsertIndex), AV18Option) == 0 ) )
            {
               AV26count = GXutil.lval( (String)AV24OptionIndexes.elementAt(-1+AV17InsertIndex)) ;
               AV26count = (long)(AV26count+1) ;
               AV24OptionIndexes.removeItem(AV17InsertIndex);
               AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), AV17InsertIndex);
            }
            else
            {
               AV19Options.add(AV18Option, AV17InsertIndex);
               AV24OptionIndexes.add("1", AV17InsertIndex);
            }
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = f1357cabf1357ldedperwcgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = f1357cabf1357ldedperwcgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = f1357cabf1357ldedperwcgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFLegIdNomApe = "" ;
      AV11TFLegIdNomApe_SelsJson = "" ;
      AV13TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34F1357CPer = "" ;
      scmdbuf = "" ;
      lV12TFLegIdNomApe = "" ;
      A250LegIdNomApe = "" ;
      A777F1357CPer = "" ;
      P00VC2_A6LegNumero = new int[1] ;
      P00VC2_A250LegIdNomApe = new String[] {""} ;
      P00VC2_A778F1357CSec = new byte[1] ;
      P00VC2_A777F1357CPer = new String[] {""} ;
      P00VC2_A784F1357CTipoPre = new byte[1] ;
      P00VC2_A1EmpCod = new short[1] ;
      P00VC2_A3CliCod = new int[1] ;
      P00VC2_A862F1357LDPTipReg = new String[] {""} ;
      A862F1357LDPTipReg = "" ;
      AV18Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357cabf1357ldedperwcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00VC2_A6LegNumero, P00VC2_A250LegIdNomApe, P00VC2_A778F1357CSec, P00VC2_A777F1357CPer, P00VC2_A784F1357CTipoPre, P00VC2_A1EmpCod, P00VC2_A3CliCod, P00VC2_A862F1357LDPTipReg
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV36F1357CTipoPre ;
   private byte AV35F1357CSec ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private short AV33EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV39GXV1 ;
   private int AV32CliCod ;
   private int AV13TFLegIdNomApe_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV17InsertIndex ;
   private long AV26count ;
   private String AV34F1357CPer ;
   private String scmdbuf ;
   private String A777F1357CPer ;
   private String A862F1357LDPTipReg ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV11TFLegIdNomApe_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV12TFLegIdNomApe ;
   private String lV12TFLegIdNomApe ;
   private String A250LegIdNomApe ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00VC2_A6LegNumero ;
   private String[] P00VC2_A250LegIdNomApe ;
   private byte[] P00VC2_A778F1357CSec ;
   private String[] P00VC2_A777F1357CPer ;
   private byte[] P00VC2_A784F1357CTipoPre ;
   private short[] P00VC2_A1EmpCod ;
   private int[] P00VC2_A3CliCod ;
   private String[] P00VC2_A862F1357LDPTipReg ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV13TFLegIdNomApe_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class f1357cabf1357ldedperwcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00VC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV13TFLegIdNomApe_Sels ,
                                          int AV13TFLegIdNomApe_Sels_size ,
                                          String AV12TFLegIdNomApe ,
                                          int AV32CliCod ,
                                          short AV33EmpCod ,
                                          byte AV36F1357CTipoPre ,
                                          String AV34F1357CPer ,
                                          byte AV35F1357CSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A784F1357CTipoPre ,
                                          String A777F1357CPer ,
                                          byte A778F1357CSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[6];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegIdNomApe, T1.F1357CSec, T1.F1357CPer, T1.F1357CTipoPre, T1.EmpCod, T1.CliCod, T1.F1357LDPTipReg FROM (F1357LDedPer T1 INNER JOIN Legajo" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.F1357CTipoPre = ? and T1.F1357CPer = ( ?) and T1.F1357CSec = ?)");
      if ( ( AV13TFLegIdNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegIdNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( AV13TFLegIdNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegIdNomApe_Sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P00VC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).byteValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).byteValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[8]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 6);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               return;
      }
   }

}


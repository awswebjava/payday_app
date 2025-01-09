package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class f1357cabwwgetfilterdata extends GXProcedure
{
   public f1357cabwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357cabwwgetfilterdata.class ), "" );
   }

   public f1357cabwwgetfilterdata( int remoteHandle ,
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
      f1357cabwwgetfilterdata.this.aP5 = new String[] {""};
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
      f1357cabwwgetfilterdata.this.AV39DDOName = aP0;
      f1357cabwwgetfilterdata.this.AV37SearchTxt = aP1;
      f1357cabwwgetfilterdata.this.AV38SearchTxtTo = aP2;
      f1357cabwwgetfilterdata.this.aP3 = aP3;
      f1357cabwwgetfilterdata.this.aP4 = aP4;
      f1357cabwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV56EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      f1357cabwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV56EmpCod = GXt_int1 ;
      GXt_int3 = AV57CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      f1357cabwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV57CliCod = GXt_int3 ;
      AV42Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV47OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWF1357Cab", GXv_boolean6) ;
      f1357cabwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_F1357CPER") == 0 )
         {
            /* Execute user subroutine: 'LOADF1357CPEROPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV43OptionsJson = AV42Options.toJSonString(false) ;
      AV46OptionsDescJson = AV45OptionsDesc.toJSonString(false) ;
      AV48OptionIndexesJson = AV47OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV50Session.getValue("F1357CabWWGridState"), "") == 0 )
      {
         AV52GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "F1357CabWWGridState"), null, null);
      }
      else
      {
         AV52GridState.fromxml(AV50Session.getValue("F1357CabWWGridState"), null, null);
      }
      AV61GXV1 = 1 ;
      while ( AV61GXV1 <= AV52GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV53GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV52GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV61GXV1));
         if ( GXutil.strcmp(AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357CPER") == 0 )
         {
            AV16TFF1357CPer = AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357CPER_SEL") == 0 )
         {
            AV15TFF1357CPer_SelsJson = AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFF1357CPer_Sels.fromJSonString(AV15TFF1357CPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357CTIPOPRE_SEL") == 0 )
         {
            AV32TFF1357CTipoPre_SelsJson = AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV33TFF1357CTipoPre_Sels.fromJSonString(AV32TFF1357CTipoPre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357CSEC") == 0 )
         {
            AV18TFF1357CSec = (byte)(GXutil.lval( AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFF1357CSec_To = (byte)(GXutil.lval( AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV58MenuOpcCod = AV53GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV61GXV1 = (int)(AV61GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADF1357CPEROPTIONS' Routine */
      returnInSub = false ;
      AV16TFF1357CPer = AV37SearchTxt ;
      AV17TFF1357CPer_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63F1357cabwwds_1_tff1357cper = AV16TFF1357CPer ;
      AV64F1357cabwwds_2_tff1357cper_sels = AV17TFF1357CPer_Sels ;
      AV65F1357cabwwds_3_tff1357ctipopre_sels = AV33TFF1357CTipoPre_Sels ;
      AV66F1357cabwwds_4_tff1357csec = AV18TFF1357CSec ;
      AV67F1357cabwwds_5_tff1357csec_to = AV19TFF1357CSec_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A777F1357CPer ,
                                           AV64F1357cabwwds_2_tff1357cper_sels ,
                                           Byte.valueOf(A784F1357CTipoPre) ,
                                           AV65F1357cabwwds_3_tff1357ctipopre_sels ,
                                           Integer.valueOf(AV64F1357cabwwds_2_tff1357cper_sels.size()) ,
                                           AV63F1357cabwwds_1_tff1357cper ,
                                           Integer.valueOf(AV65F1357cabwwds_3_tff1357ctipopre_sels.size()) ,
                                           Byte.valueOf(AV66F1357cabwwds_4_tff1357csec) ,
                                           Byte.valueOf(AV67F1357cabwwds_5_tff1357csec_to) ,
                                           Byte.valueOf(A778F1357CSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV57CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV56EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV63F1357cabwwds_1_tff1357cper = GXutil.padr( GXutil.rtrim( AV63F1357cabwwds_1_tff1357cper), 6, "%") ;
      /* Using cursor P00UT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV57CliCod), Short.valueOf(AV56EmpCod), lV63F1357cabwwds_1_tff1357cper, Byte.valueOf(AV66F1357cabwwds_4_tff1357csec), Byte.valueOf(AV67F1357cabwwds_5_tff1357csec_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkUT2 = false ;
         A3CliCod = P00UT2_A3CliCod[0] ;
         A1EmpCod = P00UT2_A1EmpCod[0] ;
         A777F1357CPer = P00UT2_A777F1357CPer[0] ;
         A778F1357CSec = P00UT2_A778F1357CSec[0] ;
         A784F1357CTipoPre = P00UT2_A784F1357CTipoPre[0] ;
         AV49count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00UT2_A777F1357CPer[0], A777F1357CPer) == 0 ) )
         {
            brkUT2 = false ;
            A3CliCod = P00UT2_A3CliCod[0] ;
            A1EmpCod = P00UT2_A1EmpCod[0] ;
            A778F1357CSec = P00UT2_A778F1357CSec[0] ;
            A784F1357CTipoPre = P00UT2_A784F1357CTipoPre[0] ;
            AV49count = (long)(AV49count+1) ;
            brkUT2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A777F1357CPer)==0) )
         {
            AV41Option = A777F1357CPer ;
            AV42Options.add(AV41Option, 0);
            AV47OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV49count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV42Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkUT2 )
         {
            brkUT2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = f1357cabwwgetfilterdata.this.AV43OptionsJson;
      this.aP4[0] = f1357cabwwgetfilterdata.this.AV46OptionsDescJson;
      this.aP5[0] = f1357cabwwgetfilterdata.this.AV48OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV43OptionsJson = "" ;
      AV46OptionsDescJson = "" ;
      AV48OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV42Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV50Session = httpContext.getWebSession();
      AV52GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV53GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV16TFF1357CPer = "" ;
      AV15TFF1357CPer_SelsJson = "" ;
      AV17TFF1357CPer_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32TFF1357CTipoPre_SelsJson = "" ;
      AV33TFF1357CTipoPre_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV58MenuOpcCod = "" ;
      A777F1357CPer = "" ;
      AV63F1357cabwwds_1_tff1357cper = "" ;
      AV64F1357cabwwds_2_tff1357cper_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65F1357cabwwds_3_tff1357ctipopre_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      scmdbuf = "" ;
      lV63F1357cabwwds_1_tff1357cper = "" ;
      P00UT2_A3CliCod = new int[1] ;
      P00UT2_A1EmpCod = new short[1] ;
      P00UT2_A777F1357CPer = new String[] {""} ;
      P00UT2_A778F1357CSec = new byte[1] ;
      P00UT2_A784F1357CTipoPre = new byte[1] ;
      AV41Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357cabwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00UT2_A3CliCod, P00UT2_A1EmpCod, P00UT2_A777F1357CPer, P00UT2_A778F1357CSec, P00UT2_A784F1357CTipoPre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18TFF1357CSec ;
   private byte AV19TFF1357CSec_To ;
   private byte AV66F1357cabwwds_4_tff1357csec ;
   private byte AV67F1357cabwwds_5_tff1357csec_to ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private short AV56EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV57CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV61GXV1 ;
   private int AV64F1357cabwwds_2_tff1357cper_sels_size ;
   private int AV65F1357cabwwds_3_tff1357ctipopre_sels_size ;
   private int A3CliCod ;
   private long AV49count ;
   private String AV16TFF1357CPer ;
   private String A777F1357CPer ;
   private String AV63F1357cabwwds_1_tff1357cper ;
   private String scmdbuf ;
   private String lV63F1357cabwwds_1_tff1357cper ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brkUT2 ;
   private String AV43OptionsJson ;
   private String AV46OptionsDescJson ;
   private String AV48OptionIndexesJson ;
   private String AV15TFF1357CPer_SelsJson ;
   private String AV32TFF1357CTipoPre_SelsJson ;
   private String AV39DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV58MenuOpcCod ;
   private String AV41Option ;
   private GXSimpleCollection<Byte> AV33TFF1357CTipoPre_Sels ;
   private GXSimpleCollection<Byte> AV65F1357cabwwds_3_tff1357ctipopre_sels ;
   private com.genexus.webpanels.WebSession AV50Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00UT2_A3CliCod ;
   private short[] P00UT2_A1EmpCod ;
   private String[] P00UT2_A777F1357CPer ;
   private byte[] P00UT2_A778F1357CSec ;
   private byte[] P00UT2_A784F1357CTipoPre ;
   private GXSimpleCollection<String> AV17TFF1357CPer_Sels ;
   private GXSimpleCollection<String> AV64F1357cabwwds_2_tff1357cper_sels ;
   private GXSimpleCollection<String> AV42Options ;
   private GXSimpleCollection<String> AV45OptionsDesc ;
   private GXSimpleCollection<String> AV47OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV52GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV53GridStateFilterValue ;
}

final  class f1357cabwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00UT2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A777F1357CPer ,
                                          GXSimpleCollection<String> AV64F1357cabwwds_2_tff1357cper_sels ,
                                          byte A784F1357CTipoPre ,
                                          GXSimpleCollection<Byte> AV65F1357cabwwds_3_tff1357ctipopre_sels ,
                                          int AV64F1357cabwwds_2_tff1357cper_sels_size ,
                                          String AV63F1357cabwwds_1_tff1357cper ,
                                          int AV65F1357cabwwds_3_tff1357ctipopre_sels_size ,
                                          byte AV66F1357cabwwds_4_tff1357csec ,
                                          byte AV67F1357cabwwds_5_tff1357csec_to ,
                                          byte A778F1357CSec ,
                                          int A3CliCod ,
                                          int AV57CliCod ,
                                          short A1EmpCod ,
                                          short AV56EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, F1357CPer, F1357CSec, F1357CTipoPre FROM F1357Cab" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ( AV64F1357cabwwds_2_tff1357cper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63F1357cabwwds_1_tff1357cper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(F1357CPer) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV64F1357cabwwds_2_tff1357cper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64F1357cabwwds_2_tff1357cper_sels, "F1357CPer IN (", ")")+")");
      }
      if ( AV65F1357cabwwds_3_tff1357ctipopre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65F1357cabwwds_3_tff1357ctipopre_sels, "F1357CTipoPre IN (", ")")+")");
      }
      if ( ! (0==AV66F1357cabwwds_4_tff1357csec) )
      {
         addWhere(sWhereString, "(F1357CSec >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV67F1357cabwwds_5_tff1357csec_to) )
      {
         addWhere(sWhereString, "(F1357CSec <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY F1357CPer" ;
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
                  return conditional_P00UT2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UT2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
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
                  stmt.setString(sIdx, (String)parms[7], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[8]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               return;
      }
   }

}


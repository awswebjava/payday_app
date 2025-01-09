package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class rolusuariowwgetfilterdata extends GXProcedure
{
   public rolusuariowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( rolusuariowwgetfilterdata.class ), "" );
   }

   public rolusuariowwgetfilterdata( int remoteHandle ,
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
      rolusuariowwgetfilterdata.this.aP5 = new String[] {""};
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
      rolusuariowwgetfilterdata.this.AV28DDOName = aP0;
      rolusuariowwgetfilterdata.this.AV29SearchTxt = aP1;
      rolusuariowwgetfilterdata.this.AV30SearchTxtTo = aP2;
      rolusuariowwgetfilterdata.this.aP3 = aP3;
      rolusuariowwgetfilterdata.this.aP4 = aP4;
      rolusuariowwgetfilterdata.this.aP5 = aP5;
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
      rolusuariowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      rolusuariowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRolUsuario", GXv_boolean6) ;
      rolusuariowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_ROLNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADROLNOMBREOPTIONS' */
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
      if ( GXutil.strcmp(AV23Session.getValue("RolUsuarioWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "RolUsuarioWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("RolUsuarioWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLID") == 0 )
         {
            AV11TFRolId = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFRolId_To = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE") == 0 )
         {
            AV14TFRolNombre = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE_SEL") == 0 )
         {
            AV13TFRolNombre_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFRolNombre_Sels.fromJSonString(AV13TFRolNombre_SelsJson, null);
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
      /* 'LOADROLNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV14TFRolNombre = AV29SearchTxt ;
      AV15TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42Rolusuariowwds_1_tfrolid = AV11TFRolId ;
      AV43Rolusuariowwds_2_tfrolid_to = AV12TFRolId_To ;
      AV44Rolusuariowwds_3_tfrolnombre = AV14TFRolNombre ;
      AV45Rolusuariowwds_4_tfrolnombre_sels = AV15TFRolNombre_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1924RolNombre ,
                                           AV45Rolusuariowwds_4_tfrolnombre_sels ,
                                           Byte.valueOf(AV42Rolusuariowwds_1_tfrolid) ,
                                           Byte.valueOf(AV43Rolusuariowwds_2_tfrolid_to) ,
                                           Integer.valueOf(AV45Rolusuariowwds_4_tfrolnombre_sels.size()) ,
                                           AV44Rolusuariowwds_3_tfrolnombre ,
                                           Byte.valueOf(A1923RolId) ,
                                           Integer.valueOf(AV36CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT
                                           }
      });
      lV44Rolusuariowwds_3_tfrolnombre = GXutil.concat( GXutil.rtrim( AV44Rolusuariowwds_3_tfrolnombre), "%", "") ;
      /* Using cursor P01UL2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV42Rolusuariowwds_1_tfrolid), Byte.valueOf(AV43Rolusuariowwds_2_tfrolid_to), lV44Rolusuariowwds_3_tfrolnombre});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1UL2 = false ;
         A1924RolNombre = P01UL2_A1924RolNombre[0] ;
         A1923RolId = P01UL2_A1923RolId[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01UL2_A1924RolNombre[0], A1924RolNombre) == 0 ) )
         {
            brk1UL2 = false ;
            A1923RolId = P01UL2_A1923RolId[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1UL2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1924RolNombre)==0) )
         {
            AV17Option = A1924RolNombre ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UL2 )
         {
            brk1UL2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = rolusuariowwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = rolusuariowwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = rolusuariowwgetfilterdata.this.AV33OptionIndexesJson;
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
      AV14TFRolNombre = "" ;
      AV13TFRolNombre_SelsJson = "" ;
      AV15TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37MenuOpcCod = "" ;
      A1924RolNombre = "" ;
      AV44Rolusuariowwds_3_tfrolnombre = "" ;
      AV45Rolusuariowwds_4_tfrolnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Rolusuariowwds_3_tfrolnombre = "" ;
      P01UL2_A1924RolNombre = new String[] {""} ;
      P01UL2_A1923RolId = new byte[1] ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.rolusuariowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01UL2_A1924RolNombre, P01UL2_A1923RolId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11TFRolId ;
   private byte AV12TFRolId_To ;
   private byte AV42Rolusuariowwds_1_tfrolid ;
   private byte AV43Rolusuariowwds_2_tfrolid_to ;
   private byte A1923RolId ;
   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV40GXV1 ;
   private int AV45Rolusuariowwds_4_tfrolnombre_sels_size ;
   private long AV22count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1UL2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFRolNombre_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFRolNombre ;
   private String AV37MenuOpcCod ;
   private String A1924RolNombre ;
   private String AV44Rolusuariowwds_3_tfrolnombre ;
   private String lV44Rolusuariowwds_3_tfrolnombre ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UL2_A1924RolNombre ;
   private byte[] P01UL2_A1923RolId ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFRolNombre_Sels ;
   private GXSimpleCollection<String> AV45Rolusuariowwds_4_tfrolnombre_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class rolusuariowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01UL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV45Rolusuariowwds_4_tfrolnombre_sels ,
                                          byte AV42Rolusuariowwds_1_tfrolid ,
                                          byte AV43Rolusuariowwds_2_tfrolid_to ,
                                          int AV45Rolusuariowwds_4_tfrolnombre_sels_size ,
                                          String AV44Rolusuariowwds_3_tfrolnombre ,
                                          byte A1923RolId ,
                                          int AV36CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT RolNombre, RolId FROM RolUsuario" ;
      if ( ! (0==AV42Rolusuariowwds_1_tfrolid) )
      {
         addWhere(sWhereString, "(RolId >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV43Rolusuariowwds_2_tfrolid_to) )
      {
         addWhere(sWhereString, "(RolId <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV45Rolusuariowwds_4_tfrolnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Rolusuariowwds_3_tfrolnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV45Rolusuariowwds_4_tfrolnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Rolusuariowwds_4_tfrolnombre_sels, "RolNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY RolNombre" ;
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
                  return conditional_P01UL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[8]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
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
                  stmt.setByte(sIdx, ((Number) parms[3]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[4]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               return;
      }
   }

}


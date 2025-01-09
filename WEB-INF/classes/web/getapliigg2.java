package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliigg2 extends GXProcedure
{
   public getapliigg2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliigg2.class ), "" );
   }

   public getapliigg2( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            byte aP1 ,
                            byte aP2 ,
                            java.math.BigDecimal aP3 ,
                            String aP4 ,
                            String aP5 ,
                            String aP6 ,
                            String aP7 )
   {
      getapliigg2.this.aP8 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        byte aP1 ,
                        byte aP2 ,
                        java.math.BigDecimal aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        short[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             byte aP1 ,
                             byte aP2 ,
                             java.math.BigDecimal aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             short[] aP8 )
   {
      getapliigg2.this.AV8CliCod = aP0;
      getapliigg2.this.AV9AplIIGGTrat = aP1;
      getapliigg2.this.AV10TipoTope = aP2;
      getapliigg2.this.AV12AplIIGGPropor = aP3;
      getapliigg2.this.AV13AplIIGGTopeVar = aP4;
      getapliigg2.this.AV14AplIIGGTopeCon = aP5;
      getapliigg2.this.AV15AplIIGGExenCon = aP6;
      getapliigg2.this.AV16AplIIGGCondicion = aP7;
      getapliigg2.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, "1") ;
      AV20GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV15AplIIGGExenCon ,
                                           Byte.valueOf(AV10TipoTope) ,
                                           AV16AplIIGGCondicion ,
                                           A1117AplIIGGExenCon ,
                                           A1109AplIIGGTopeVar ,
                                           AV13AplIIGGTopeVar ,
                                           A1111AplIIGGTopeCon ,
                                           AV14AplIIGGTopeCon ,
                                           A1124AplIIGGCondicion ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           Byte.valueOf(AV9AplIIGGTrat) ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           A1114AplIIGGPropor ,
                                           AV12AplIIGGPropor ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P026X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Byte.valueOf(AV9AplIIGGTrat), Byte.valueOf(AV10TipoTope), AV12AplIIGGPropor, AV15AplIIGGExenCon, AV13AplIIGGTopeVar, AV14AplIIGGTopeCon, AV16AplIIGGCondicion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1124AplIIGGCondicion = P026X2_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P026X2_n1124AplIIGGCondicion[0] ;
         A1111AplIIGGTopeCon = P026X2_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P026X2_n1111AplIIGGTopeCon[0] ;
         A1109AplIIGGTopeVar = P026X2_A1109AplIIGGTopeVar[0] ;
         n1109AplIIGGTopeVar = P026X2_n1109AplIIGGTopeVar[0] ;
         A1114AplIIGGPropor = P026X2_A1114AplIIGGPropor[0] ;
         A1117AplIIGGExenCon = P026X2_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P026X2_n1117AplIIGGExenCon[0] ;
         A1115AplIIGGTopeTip = P026X2_A1115AplIIGGTopeTip[0] ;
         A1120AplIIGGTrat = P026X2_A1120AplIIGGTrat[0] ;
         A3CliCod = P026X2_A3CliCod[0] ;
         A1112AplIIGG = P026X2_A1112AplIIGG[0] ;
         AV20GXLvl2 = (byte)(1) ;
         AV11AplIIGG = A1112AplIIGG ;
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "encuentra &AplIIGG ", "")+GXutil.trim( GXutil.str( AV11AplIIGG, 4, 0))+httpContext.getMessage( " para ", "")+GXutil.trim( AV15AplIIGGExenCon)) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV20GXLvl2 == 0 )
      {
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "none &AplIIGGExenCon", "")+GXutil.trim( AV15AplIIGGExenCon)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getapliigg2.this.AV11AplIIGG;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Pgmname = "" ;
      scmdbuf = "" ;
      A1117AplIIGGExenCon = "" ;
      A1109AplIIGGTopeVar = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1124AplIIGGCondicion = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      P026X2_A1124AplIIGGCondicion = new String[] {""} ;
      P026X2_n1124AplIIGGCondicion = new boolean[] {false} ;
      P026X2_A1111AplIIGGTopeCon = new String[] {""} ;
      P026X2_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P026X2_A1109AplIIGGTopeVar = new String[] {""} ;
      P026X2_n1109AplIIGGTopeVar = new boolean[] {false} ;
      P026X2_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026X2_A1117AplIIGGExenCon = new String[] {""} ;
      P026X2_n1117AplIIGGExenCon = new boolean[] {false} ;
      P026X2_A1115AplIIGGTopeTip = new byte[1] ;
      P026X2_A1120AplIIGGTrat = new byte[1] ;
      P026X2_A3CliCod = new int[1] ;
      P026X2_A1112AplIIGG = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getapliigg2__default(),
         new Object[] {
             new Object[] {
            P026X2_A1124AplIIGGCondicion, P026X2_n1124AplIIGGCondicion, P026X2_A1111AplIIGGTopeCon, P026X2_n1111AplIIGGTopeCon, P026X2_A1109AplIIGGTopeVar, P026X2_n1109AplIIGGTopeVar, P026X2_A1114AplIIGGPropor, P026X2_A1117AplIIGGExenCon, P026X2_n1117AplIIGGExenCon, P026X2_A1115AplIIGGTopeTip,
            P026X2_A1120AplIIGGTrat, P026X2_A3CliCod, P026X2_A1112AplIIGG
            }
         }
      );
      AV19Pgmname = "getAplIIGG2" ;
      /* GeneXus formulas. */
      AV19Pgmname = "getAplIIGG2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9AplIIGGTrat ;
   private byte AV10TipoTope ;
   private byte AV20GXLvl2 ;
   private byte A1120AplIIGGTrat ;
   private byte A1115AplIIGGTopeTip ;
   private short AV11AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12AplIIGGPropor ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private String AV13AplIIGGTopeVar ;
   private String AV14AplIIGGTopeCon ;
   private String AV15AplIIGGExenCon ;
   private String AV16AplIIGGCondicion ;
   private String AV19Pgmname ;
   private String scmdbuf ;
   private String A1117AplIIGGExenCon ;
   private String A1109AplIIGGTopeVar ;
   private String A1111AplIIGGTopeCon ;
   private String A1124AplIIGGCondicion ;
   private boolean n1124AplIIGGCondicion ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean n1117AplIIGGExenCon ;
   private short[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P026X2_A1124AplIIGGCondicion ;
   private boolean[] P026X2_n1124AplIIGGCondicion ;
   private String[] P026X2_A1111AplIIGGTopeCon ;
   private boolean[] P026X2_n1111AplIIGGTopeCon ;
   private String[] P026X2_A1109AplIIGGTopeVar ;
   private boolean[] P026X2_n1109AplIIGGTopeVar ;
   private java.math.BigDecimal[] P026X2_A1114AplIIGGPropor ;
   private String[] P026X2_A1117AplIIGGExenCon ;
   private boolean[] P026X2_n1117AplIIGGExenCon ;
   private byte[] P026X2_A1115AplIIGGTopeTip ;
   private byte[] P026X2_A1120AplIIGGTrat ;
   private int[] P026X2_A3CliCod ;
   private short[] P026X2_A1112AplIIGG ;
}

final  class getapliigg2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P026X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV15AplIIGGExenCon ,
                                          byte AV10TipoTope ,
                                          String AV16AplIIGGCondicion ,
                                          String A1117AplIIGGExenCon ,
                                          String A1109AplIIGGTopeVar ,
                                          String AV13AplIIGGTopeVar ,
                                          String A1111AplIIGGTopeCon ,
                                          String AV14AplIIGGTopeCon ,
                                          String A1124AplIIGGCondicion ,
                                          byte A1120AplIIGGTrat ,
                                          byte AV9AplIIGGTrat ,
                                          byte A1115AplIIGGTopeTip ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal AV12AplIIGGPropor ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[8];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT AplIIGGCondicion, AplIIGGTopeCon, AplIIGGTopeVar, AplIIGGPropor, AplIIGGExenCon, AplIIGGTopeTip, AplIIGGTrat, CliCod, AplIIGG FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(AplIIGGTrat = ?)");
      addWhere(sWhereString, "(AplIIGGTopeTip = ?)");
      addWhere(sWhereString, "(AplIIGGPropor = ?)");
      if ( ! (GXutil.strcmp("", AV15AplIIGGExenCon)==0) )
      {
         addWhere(sWhereString, "(AplIIGGExenCon = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      if ( AV10TipoTope == 1 )
      {
         addWhere(sWhereString, "(AplIIGGTopeVar = ( ?))");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
      }
      if ( AV10TipoTope == 2 )
      {
         addWhere(sWhereString, "(AplIIGGTopeCon = ( ?))");
      }
      else
      {
         GXv_int1[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV16AplIIGGCondicion)==0) )
      {
         addWhere(sWhereString, "(AplIIGGCondicion = ( ?))");
      }
      else
      {
         GXv_int1[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P026X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).byteValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 40);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[7])[0] = rslt.getString(5, 10);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((byte[]) buf[10])[0] = rslt.getByte(7);
               ((int[]) buf[11])[0] = rslt.getInt(8);
               ((short[]) buf[12])[0] = rslt.getShort(9);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               return;
      }
   }

}


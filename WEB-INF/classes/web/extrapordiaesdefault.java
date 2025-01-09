package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class extrapordiaesdefault extends GXProcedure
{
   public extrapordiaesdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( extrapordiaesdefault.class ), "" );
   }

   public extrapordiaesdefault( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              byte aP2 ,
                              String aP3 ,
                              java.math.BigDecimal aP4 ,
                              java.math.BigDecimal aP5 ,
                              String aP6 )
   {
      extrapordiaesdefault.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        byte aP2 ,
                        String aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        String aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             String aP6 ,
                             boolean[] aP7 )
   {
      extrapordiaesdefault.this.AV8PaiCod = aP0;
      extrapordiaesdefault.this.AV9PaiHsPDiaTipTra = aP1;
      extrapordiaesdefault.this.AV10PaiHsPDiaDia = aP2;
      extrapordiaesdefault.this.AV11PaiHsPDiaDesde = aP3;
      extrapordiaesdefault.this.AV12PaiTarifaPDia = aP4;
      extrapordiaesdefault.this.AV13PaiTarifaPDRec = aP5;
      extrapordiaesdefault.this.AV15PaiTarifaPDCri = aP6;
      extrapordiaesdefault.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV8PaiCod, 4, 0))+httpContext.getMessage( " &PaiHsPDiaTipTra ", "")+GXutil.trim( AV9PaiHsPDiaTipTra)+httpContext.getMessage( " &PaiHsPDiaDia ", "")+GXutil.trim( GXutil.str( AV10PaiHsPDiaDia, 1, 0))+httpContext.getMessage( " &PaiHsPDiaDesde ", "")+GXutil.trim( AV11PaiHsPDiaDesde)+httpContext.getMessage( " &PaiTarifaPDRec ", "")+GXutil.trim( GXutil.str( AV13PaiTarifaPDRec, 6, 4))+httpContext.getMessage( " &defaultEs ", "")+GXutil.trim( GXutil.booltostr( AV14defaultEs))) ;
      AV19GXLvl5 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11PaiHsPDiaDesde ,
                                           A1334PaiHsPDiaDesde ,
                                           Byte.valueOf(A1333PaiHsPDiaDia) ,
                                           Byte.valueOf(AV10PaiHsPDiaDia) ,
                                           A1335PaiTarifaPDia ,
                                           AV12PaiTarifaPDia ,
                                           A1348PaiTarifaPDRec ,
                                           AV13PaiTarifaPDRec ,
                                           A2434PaiTarifaPDCri ,
                                           AV15PaiTarifaPDCri ,
                                           Short.valueOf(AV8PaiCod) ,
                                           AV9PaiHsPDiaTipTra ,
                                           Short.valueOf(A46PaiCod) ,
                                           A1331PaiHsPDiaTipTra } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01SV2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9PaiHsPDiaTipTra, Byte.valueOf(AV10PaiHsPDiaDia), AV12PaiTarifaPDia, AV13PaiTarifaPDRec, AV15PaiTarifaPDCri, AV11PaiHsPDiaDesde});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2434PaiTarifaPDCri = P01SV2_A2434PaiTarifaPDCri[0] ;
         A1348PaiTarifaPDRec = P01SV2_A1348PaiTarifaPDRec[0] ;
         A1335PaiTarifaPDia = P01SV2_A1335PaiTarifaPDia[0] ;
         A1334PaiHsPDiaDesde = P01SV2_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = P01SV2_n1334PaiHsPDiaDesde[0] ;
         A1333PaiHsPDiaDia = P01SV2_A1333PaiHsPDiaDia[0] ;
         A1331PaiHsPDiaTipTra = P01SV2_A1331PaiHsPDiaTipTra[0] ;
         A46PaiCod = P01SV2_A46PaiCod[0] ;
         A1332PaiHsExSec = P01SV2_A1332PaiHsExSec[0] ;
         AV19GXLvl5 = (byte)(1) ;
         AV14defaultEs = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV19GXLvl5 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = extrapordiaesdefault.this.AV14defaultEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18Pgmname = "" ;
      scmdbuf = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      A1331PaiHsPDiaTipTra = "" ;
      P01SV2_A2434PaiTarifaPDCri = new String[] {""} ;
      P01SV2_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SV2_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SV2_A1334PaiHsPDiaDesde = new String[] {""} ;
      P01SV2_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      P01SV2_A1333PaiHsPDiaDia = new byte[1] ;
      P01SV2_A1331PaiHsPDiaTipTra = new String[] {""} ;
      P01SV2_A46PaiCod = new short[1] ;
      P01SV2_A1332PaiHsExSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.extrapordiaesdefault__default(),
         new Object[] {
             new Object[] {
            P01SV2_A2434PaiTarifaPDCri, P01SV2_A1348PaiTarifaPDRec, P01SV2_A1335PaiTarifaPDia, P01SV2_A1334PaiHsPDiaDesde, P01SV2_n1334PaiHsPDiaDesde, P01SV2_A1333PaiHsPDiaDia, P01SV2_A1331PaiHsPDiaTipTra, P01SV2_A46PaiCod, P01SV2_A1332PaiHsExSec
            }
         }
      );
      AV18Pgmname = "extraPorDiaEsDefault" ;
      /* GeneXus formulas. */
      AV18Pgmname = "extraPorDiaEsDefault" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10PaiHsPDiaDia ;
   private byte AV19GXLvl5 ;
   private byte A1333PaiHsPDiaDia ;
   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short A1332PaiHsExSec ;
   private short Gx_err ;
   private java.math.BigDecimal AV12PaiTarifaPDia ;
   private java.math.BigDecimal AV13PaiTarifaPDRec ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private String AV9PaiHsPDiaTipTra ;
   private String AV11PaiHsPDiaDesde ;
   private String AV15PaiTarifaPDCri ;
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String A1334PaiHsPDiaDesde ;
   private String A2434PaiTarifaPDCri ;
   private String A1331PaiHsPDiaTipTra ;
   private boolean AV14defaultEs ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P01SV2_A2434PaiTarifaPDCri ;
   private java.math.BigDecimal[] P01SV2_A1348PaiTarifaPDRec ;
   private java.math.BigDecimal[] P01SV2_A1335PaiTarifaPDia ;
   private String[] P01SV2_A1334PaiHsPDiaDesde ;
   private boolean[] P01SV2_n1334PaiHsPDiaDesde ;
   private byte[] P01SV2_A1333PaiHsPDiaDia ;
   private String[] P01SV2_A1331PaiHsPDiaTipTra ;
   private short[] P01SV2_A46PaiCod ;
   private short[] P01SV2_A1332PaiHsExSec ;
}

final  class extrapordiaesdefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01SV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV11PaiHsPDiaDesde ,
                                          String A1334PaiHsPDiaDesde ,
                                          byte A1333PaiHsPDiaDia ,
                                          byte AV10PaiHsPDiaDia ,
                                          java.math.BigDecimal A1335PaiTarifaPDia ,
                                          java.math.BigDecimal AV12PaiTarifaPDia ,
                                          java.math.BigDecimal A1348PaiTarifaPDRec ,
                                          java.math.BigDecimal AV13PaiTarifaPDRec ,
                                          String A2434PaiTarifaPDCri ,
                                          String AV15PaiTarifaPDCri ,
                                          short AV8PaiCod ,
                                          String AV9PaiHsPDiaTipTra ,
                                          short A46PaiCod ,
                                          String A1331PaiHsPDiaTipTra )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[7];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT PaiTarifaPDCri, PaiTarifaPDRec, PaiTarifaPDia, PaiHsPDiaDesde, PaiHsPDiaDia, PaiHsPDiaTipTra, PaiCod, PaiHsExSec FROM Paishorasextras_pordia" ;
      addWhere(sWhereString, "(PaiCod = ? and PaiHsPDiaTipTra = ( ?))");
      addWhere(sWhereString, "(PaiHsPDiaDia = ?)");
      addWhere(sWhereString, "(PaiTarifaPDia = ?)");
      addWhere(sWhereString, "(PaiTarifaPDRec = ?)");
      addWhere(sWhereString, "(PaiTarifaPDCri = ( ?))");
      if ( ! (GXutil.strcmp("", AV11PaiHsPDiaDesde)==0) )
      {
         addWhere(sWhereString, "(PaiHsPDiaDesde = ( ?))");
      }
      else
      {
         GXv_int1[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11PaiHsPDiaDesde)==0) )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from PaiHsPDiaDesde))=0) or PaiHsPDiaDesde IS NULL)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, PaiHsPDiaTipTra" ;
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
                  return conditional_P01SV2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 5);
               }
               return;
      }
   }

}


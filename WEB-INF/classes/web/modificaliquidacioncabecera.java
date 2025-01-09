package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class modificaliquidacioncabecera extends GXProcedure
{
   public modificaliquidacioncabecera( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( modificaliquidacioncabecera.class ), "" );
   }

   public modificaliquidacioncabecera( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        byte aP6 ,
                        java.util.Date aP7 ,
                        String aP8 ,
                        short aP9 ,
                        byte aP10 ,
                        String aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             byte aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             short aP9 ,
                             byte aP10 ,
                             String aP11 )
   {
      modificaliquidacioncabecera.this.AV9CliCod = aP0;
      modificaliquidacioncabecera.this.AV10EmpCod = aP1;
      modificaliquidacioncabecera.this.AV11LiqNro = aP2;
      modificaliquidacioncabecera.this.AV18LiqDescrip = aP3;
      modificaliquidacioncabecera.this.AV17LiqFecPago = aP4;
      modificaliquidacioncabecera.this.AV8LiqPerAno = aP5;
      modificaliquidacioncabecera.this.AV12LiqPerMes = aP6;
      modificaliquidacioncabecera.this.AV16LiqDepPrvFec = aP7;
      modificaliquidacioncabecera.this.AV15LiqDepBanCod = aP8;
      modificaliquidacioncabecera.this.AV14LiqDepPerAno = aP9;
      modificaliquidacioncabecera.this.AV13LiqDepPerMes = aP10;
      modificaliquidacioncabecera.this.AV19LiqNombre = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00L22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00L22_A31LiqNro[0] ;
         A1EmpCod = P00L22_A1EmpCod[0] ;
         A3CliCod = P00L22_A3CliCod[0] ;
         A271LiqDescrip = P00L22_A271LiqDescrip[0] ;
         A280LiqFecPago = P00L22_A280LiqFecPago[0] ;
         A581LiqDepPrvFec = P00L22_A581LiqDepPrvFec[0] ;
         A33LiqDepBanCod = P00L22_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = P00L22_n33LiqDepBanCod[0] ;
         A583LiqDepPerAno = P00L22_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = P00L22_A584LiqDepPerMes[0] ;
         A580LiqDepPrvPer = P00L22_A580LiqDepPrvPer[0] ;
         A587LiqFecMod = P00L22_A587LiqFecMod[0] ;
         A588LiqUsuMod = P00L22_A588LiqUsuMod[0] ;
         A874LiqNombre = P00L22_A874LiqNombre[0] ;
         A271LiqDescrip = AV18LiqDescrip ;
         A280LiqFecPago = AV17LiqFecPago ;
         A581LiqDepPrvFec = AV16LiqDepPrvFec ;
         if ( ! (GXutil.strcmp("", AV15LiqDepBanCod)==0) )
         {
            A33LiqDepBanCod = AV15LiqDepBanCod ;
            n33LiqDepBanCod = false ;
         }
         else
         {
            A33LiqDepBanCod = "" ;
            n33LiqDepBanCod = false ;
            n33LiqDepBanCod = true ;
         }
         A583LiqDepPerAno = AV14LiqDepPerAno ;
         A584LiqDepPerMes = AV13LiqDepPerMes ;
         A580LiqDepPrvPer = GXutil.padl( GXutil.str( AV13LiqDepPerMes, 2, 0), (short)(2), "0") + "/" + GXutil.trim( GXutil.str( AV14LiqDepPerAno, 4, 0)) ;
         A587LiqFecMod = GXutil.serverNow( context, remoteHandle, pr_default) ;
         GXt_char1 = A588LiqUsuMod ;
         GXv_char2[0] = GXt_char1 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
         modificaliquidacioncabecera.this.GXt_char1 = GXv_char2[0] ;
         A588LiqUsuMod = GXt_char1 ;
         A874LiqNombre = AV19LiqNombre ;
         /* Using cursor P00L23 */
         pr_default.execute(1, new Object[] {A271LiqDescrip, A280LiqFecPago, A581LiqDepPrvFec, Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod, Short.valueOf(A583LiqDepPerAno), Byte.valueOf(A584LiqDepPerMes), A580LiqDepPrvPer, A587LiqFecMod, A588LiqUsuMod, A874LiqNombre, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "modificaliquidacioncabecera");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00L22_A31LiqNro = new int[1] ;
      P00L22_A1EmpCod = new short[1] ;
      P00L22_A3CliCod = new int[1] ;
      P00L22_A271LiqDescrip = new String[] {""} ;
      P00L22_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P00L22_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      P00L22_A33LiqDepBanCod = new String[] {""} ;
      P00L22_n33LiqDepBanCod = new boolean[] {false} ;
      P00L22_A583LiqDepPerAno = new short[1] ;
      P00L22_A584LiqDepPerMes = new byte[1] ;
      P00L22_A580LiqDepPrvPer = new String[] {""} ;
      P00L22_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      P00L22_A588LiqUsuMod = new String[] {""} ;
      P00L22_A874LiqNombre = new String[] {""} ;
      A271LiqDescrip = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      A33LiqDepBanCod = "" ;
      A580LiqDepPrvPer = "" ;
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      A588LiqUsuMod = "" ;
      A874LiqNombre = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.modificaliquidacioncabecera__default(),
         new Object[] {
             new Object[] {
            P00L22_A31LiqNro, P00L22_A1EmpCod, P00L22_A3CliCod, P00L22_A271LiqDescrip, P00L22_A280LiqFecPago, P00L22_A581LiqDepPrvFec, P00L22_A33LiqDepBanCod, P00L22_n33LiqDepBanCod, P00L22_A583LiqDepPerAno, P00L22_A584LiqDepPerMes,
            P00L22_A580LiqDepPrvPer, P00L22_A587LiqFecMod, P00L22_A588LiqUsuMod, P00L22_A874LiqNombre
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12LiqPerMes ;
   private byte AV13LiqDepPerMes ;
   private byte A584LiqDepPerMes ;
   private short AV10EmpCod ;
   private short AV8LiqPerAno ;
   private short AV14LiqDepPerAno ;
   private short A1EmpCod ;
   private short A583LiqDepPerAno ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV15LiqDepBanCod ;
   private String scmdbuf ;
   private String A33LiqDepBanCod ;
   private String A580LiqDepPrvPer ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date A587LiqFecMod ;
   private java.util.Date AV17LiqFecPago ;
   private java.util.Date AV16LiqDepPrvFec ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A581LiqDepPrvFec ;
   private boolean n33LiqDepBanCod ;
   private String AV18LiqDescrip ;
   private String AV19LiqNombre ;
   private String A271LiqDescrip ;
   private String A588LiqUsuMod ;
   private String A874LiqNombre ;
   private IDataStoreProvider pr_default ;
   private int[] P00L22_A31LiqNro ;
   private short[] P00L22_A1EmpCod ;
   private int[] P00L22_A3CliCod ;
   private String[] P00L22_A271LiqDescrip ;
   private java.util.Date[] P00L22_A280LiqFecPago ;
   private java.util.Date[] P00L22_A581LiqDepPrvFec ;
   private String[] P00L22_A33LiqDepBanCod ;
   private boolean[] P00L22_n33LiqDepBanCod ;
   private short[] P00L22_A583LiqDepPerAno ;
   private byte[] P00L22_A584LiqDepPerMes ;
   private String[] P00L22_A580LiqDepPrvPer ;
   private java.util.Date[] P00L22_A587LiqFecMod ;
   private String[] P00L22_A588LiqUsuMod ;
   private String[] P00L22_A874LiqNombre ;
}

final  class modificaliquidacioncabecera__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00L22", "SELECT LiqNro, EmpCod, CliCod, LiqDescrip, LiqFecPago, LiqDepPrvFec, LiqDepBanCod, LiqDepPerAno, LiqDepPerMes, LiqDepPrvPer, LiqFecMod, LiqUsuMod, LiqNombre FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00L23", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqDescrip=?, LiqFecPago=?, LiqDepPrvFec=?, LiqDepBanCod=?, LiqDepPerAno=?, LiqDepPerMes=?, LiqDepPrvPer=?, LiqFecMod=?, LiqUsuMod=?, LiqNombre=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(11);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 6);
               }
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setDateTime(8, (java.util.Date)parms[8], false);
               stmt.setVarchar(9, (String)parms[9], 100, false);
               stmt.setVarchar(10, (String)parms[10], 400, false);
               stmt.setInt(11, ((Number) parms[11]).intValue());
               stmt.setShort(12, ((Number) parms[12]).shortValue());
               stmt.setInt(13, ((Number) parms[13]).intValue());
               return;
      }
   }

}


package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipooblsecporcodigo extends GXProcedure
{
   public gettipooblsecporcodigo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipooblsecporcodigo.class ), "" );
   }

   public gettipooblsecporcodigo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( short aP0 ,
                           String aP1 ,
                           short[] aP2 ,
                           boolean[] aP3 ,
                           byte[] aP4 ,
                           short[] aP5 ,
                           String[] aP6 )
   {
      gettipooblsecporcodigo.this.aP7 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        short[] aP2 ,
                        boolean[] aP3 ,
                        byte[] aP4 ,
                        short[] aP5 ,
                        String[] aP6 ,
                        byte[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             short[] aP2 ,
                             boolean[] aP3 ,
                             byte[] aP4 ,
                             short[] aP5 ,
                             String[] aP6 ,
                             byte[] aP7 )
   {
      gettipooblsecporcodigo.this.AV8PaiCod = aP0;
      gettipooblsecporcodigo.this.AV9TipoOblCodigo = aP1;
      gettipooblsecporcodigo.this.aP2 = aP2;
      gettipooblsecporcodigo.this.aP3 = aP3;
      gettipooblsecporcodigo.this.aP4 = aP4;
      gettipooblsecporcodigo.this.aP5 = aP5;
      gettipooblsecporcodigo.this.aP6 = aP6;
      gettipooblsecporcodigo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14LiqDCalculado = (byte)(1) ;
      AV18GXLvl2 = (byte)(0) ;
      /* Using cursor P01A92 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9TipoOblCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1164TipoOblCodigo = P01A92_A1164TipoOblCodigo[0] ;
         A1159TipoOblPaiCod = P01A92_A1159TipoOblPaiCod[0] ;
         A1167TipoOblAnti = P01A92_A1167TipoOblAnti[0] ;
         A1168TipoOblTotTipo = P01A92_A1168TipoOblTotTipo[0] ;
         A1163TipoOblSec = P01A92_A1163TipoOblSec[0] ;
         A1161EmbargaSec = P01A92_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P01A92_n1161EmbargaSec[0] ;
         AV18GXLvl2 = (byte)(1) ;
         AV10TipoOblAnti = A1167TipoOblAnti ;
         AV11TipoOblTotTipo = A1168TipoOblTotTipo ;
         AV12TipoOblSec = A1163TipoOblSec ;
         AV15EmbargaSec = A1161EmbargaSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18GXLvl2 == 0 )
      {
         AV13error = httpContext.getMessage( "No existe obligación tipo ", "") + GXutil.trim( AV9TipoOblCodigo) ;
         AV14LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( false )
      {
         new web.pendientesdeoptimizarcasesensitive(remoteHandle, context).execute( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipooblsecporcodigo.this.AV12TipoOblSec;
      this.aP3[0] = gettipooblsecporcodigo.this.AV10TipoOblAnti;
      this.aP4[0] = gettipooblsecporcodigo.this.AV11TipoOblTotTipo;
      this.aP5[0] = gettipooblsecporcodigo.this.AV15EmbargaSec;
      this.aP6[0] = gettipooblsecporcodigo.this.AV13error;
      this.aP7[0] = gettipooblsecporcodigo.this.AV14LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13error = "" ;
      scmdbuf = "" ;
      P01A92_A1164TipoOblCodigo = new String[] {""} ;
      P01A92_A1159TipoOblPaiCod = new short[1] ;
      P01A92_A1167TipoOblAnti = new boolean[] {false} ;
      P01A92_A1168TipoOblTotTipo = new byte[1] ;
      P01A92_A1163TipoOblSec = new short[1] ;
      P01A92_A1161EmbargaSec = new short[1] ;
      P01A92_n1161EmbargaSec = new boolean[] {false} ;
      A1164TipoOblCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipooblsecporcodigo__default(),
         new Object[] {
             new Object[] {
            P01A92_A1164TipoOblCodigo, P01A92_A1159TipoOblPaiCod, P01A92_A1167TipoOblAnti, P01A92_A1168TipoOblTotTipo, P01A92_A1163TipoOblSec, P01A92_A1161EmbargaSec, P01A92_n1161EmbargaSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11TipoOblTotTipo ;
   private byte AV14LiqDCalculado ;
   private byte AV18GXLvl2 ;
   private byte A1168TipoOblTotTipo ;
   private short AV8PaiCod ;
   private short AV12TipoOblSec ;
   private short AV15EmbargaSec ;
   private short A1159TipoOblPaiCod ;
   private short A1163TipoOblSec ;
   private short A1161EmbargaSec ;
   private short Gx_err ;
   private String AV9TipoOblCodigo ;
   private String scmdbuf ;
   private String A1164TipoOblCodigo ;
   private boolean AV10TipoOblAnti ;
   private boolean A1167TipoOblAnti ;
   private boolean n1161EmbargaSec ;
   private boolean returnInSub ;
   private String AV13error ;
   private byte[] aP7 ;
   private short[] aP2 ;
   private boolean[] aP3 ;
   private byte[] aP4 ;
   private short[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01A92_A1164TipoOblCodigo ;
   private short[] P01A92_A1159TipoOblPaiCod ;
   private boolean[] P01A92_A1167TipoOblAnti ;
   private byte[] P01A92_A1168TipoOblTotTipo ;
   private short[] P01A92_A1163TipoOblSec ;
   private short[] P01A92_A1161EmbargaSec ;
   private boolean[] P01A92_n1161EmbargaSec ;
}

final  class gettipooblsecporcodigo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01A92", "SELECT TipoOblCodigo, TipoOblPaiCod, TipoOblAnti, TipoOblTotTipo, TipoOblSec, EmbargaSec FROM tipo_obligacion WHERE (TipoOblPaiCod = ?) AND (UPPER(RTRIM(LTRIM(TipoOblCodigo))) = ( UPPER(RTRIM(LTRIM(?))))) ORDER BY TipoOblPaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}


package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustarimporteconvenio extends GXProcedure
{
   public ajustarimporteconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustarimporteconvenio.class ), "" );
   }

   public ajustarimporteconvenio( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             int aP7 )
   {
      ajustarimporteconvenio.this.AV9CliCod = aP0;
      ajustarimporteconvenio.this.AV10CliPaiConve = aP1;
      ajustarimporteconvenio.this.AV11CliConvenio = aP2;
      ajustarimporteconvenio.this.AV28origenCliConveImpVig = aP3;
      ajustarimporteconvenio.this.AV18porUnaje = aP4;
      ajustarimporteconvenio.this.AV25CliConveImpVig = aP5;
      ajustarimporteconvenio.this.AV29que = aP6;
      ajustarimporteconvenio.this.AV30CliConveImpRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01P72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10CliPaiConve), AV11CliConvenio, AV28origenCliConveImpVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1896CliConveImpRelSec = P01P72_A1896CliConveImpRelSec[0] ;
         A1589CliConveImporte = P01P72_A1589CliConveImporte[0] ;
         A1588CliConveImpTipo = P01P72_A1588CliConveImpTipo[0] ;
         A1587CliConveImpVig = P01P72_A1587CliConveImpVig[0] ;
         A1565CliConvenio = P01P72_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01P72_A1564CliPaiConve[0] ;
         A3CliCod = P01P72_A3CliCod[0] ;
         A2045CliConveImpOld = P01P72_A2045CliConveImpOld[0] ;
         A2044CliConveImpRelRef = P01P72_A2044CliConveImpRelRef[0] ;
         W3CliCod = A3CliCod ;
         W1564CliPaiConve = A1564CliPaiConve ;
         W1565CliConvenio = A1565CliConvenio ;
         W1587CliConveImpVig = A1587CliConveImpVig ;
         if ( GXutil.strcmp(AV29que, httpContext.getMessage( "Truncar", "")) == 0 )
         {
            AV26CliConveImporte = GXutil.truncDecimal( A1589CliConveImporte.multiply(AV18porUnaje), 0) ;
         }
         else
         {
            if ( GXutil.strcmp(AV29que, httpContext.getMessage( "Redondear", "")) == 0 )
            {
               AV26CliConveImporte = GXutil.roundDecimal( A1589CliConveImporte.multiply(AV18porUnaje), 0) ;
            }
            else
            {
               if ( GXutil.strcmp(AV29que, httpContext.getMessage( "RedondearUp", "")) == 0 )
               {
                  AV26CliConveImporte = GXutil.roundToEven( A1589CliConveImporte.multiply(AV18porUnaje), 0) ;
               }
               else
               {
                  AV26CliConveImporte = A1589CliConveImporte.multiply(AV18porUnaje) ;
               }
            }
         }
         AV27CliConveImpTipo = A1588CliConveImpTipo ;
         /*
            INSERT RECORD ON TABLE clienteConvenio_importes

         */
         W3CliCod = A3CliCod ;
         W1564CliPaiConve = A1564CliPaiConve ;
         W1565CliConvenio = A1565CliConvenio ;
         W1588CliConveImpTipo = A1588CliConveImpTipo ;
         W1587CliConveImpVig = A1587CliConveImpVig ;
         W1589CliConveImporte = A1589CliConveImporte ;
         W1896CliConveImpRelSec = A1896CliConveImpRelSec ;
         A3CliCod = AV9CliCod ;
         A1564CliPaiConve = AV10CliPaiConve ;
         A1565CliConvenio = AV11CliConvenio ;
         A1588CliConveImpTipo = AV27CliConveImpTipo ;
         A1587CliConveImpVig = AV25CliConveImpVig ;
         A1589CliConveImporte = AV26CliConveImporte ;
         A1896CliConveImpRelSec = AV30CliConveImpRelSec ;
         /* Using cursor P01P73 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte, Integer.valueOf(A1896CliConveImpRelSec), A2044CliConveImpRelRef, A2045CliConveImpOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            /* Optimized UPDATE. */
            /* Using cursor P01P74 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV30CliConveImpRelSec), AV26CliConveImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
            /* End optimized UPDATE. */
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         A3CliCod = W3CliCod ;
         A1564CliPaiConve = W1564CliPaiConve ;
         A1565CliConvenio = W1565CliConvenio ;
         A1588CliConveImpTipo = W1588CliConveImpTipo ;
         A1587CliConveImpVig = W1587CliConveImpVig ;
         A1589CliConveImporte = W1589CliConveImporte ;
         A1896CliConveImpRelSec = W1896CliConveImpRelSec ;
         /* End Insert */
         A3CliCod = W3CliCod ;
         A1564CliPaiConve = W1564CliPaiConve ;
         A1565CliConvenio = W1565CliConvenio ;
         A1587CliConveImpVig = W1587CliConveImpVig ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ajustarimporteconvenio");
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
      P01P72_A1896CliConveImpRelSec = new int[1] ;
      P01P72_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01P72_A1588CliConveImpTipo = new String[] {""} ;
      P01P72_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01P72_A1565CliConvenio = new String[] {""} ;
      P01P72_A1564CliPaiConve = new short[1] ;
      P01P72_A3CliCod = new int[1] ;
      P01P72_A2045CliConveImpOld = new String[] {""} ;
      P01P72_A2044CliConveImpRelRef = new String[] {""} ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      A1588CliConveImpTipo = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1565CliConvenio = "" ;
      A2045CliConveImpOld = "" ;
      A2044CliConveImpRelRef = "" ;
      W1565CliConvenio = "" ;
      W1587CliConveImpVig = GXutil.nullDate() ;
      AV26CliConveImporte = DecimalUtil.ZERO ;
      AV27CliConveImpTipo = "" ;
      W1588CliConveImpTipo = "" ;
      W1589CliConveImporte = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustarimporteconvenio__default(),
         new Object[] {
             new Object[] {
            P01P72_A1896CliConveImpRelSec, P01P72_A1589CliConveImporte, P01P72_A1588CliConveImpTipo, P01P72_A1587CliConveImpVig, P01P72_A1565CliConvenio, P01P72_A1564CliPaiConve, P01P72_A3CliCod, P01P72_A2045CliConveImpOld, P01P72_A2044CliConveImpRelRef
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short W1564CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV30CliConveImpRelSec ;
   private int A1896CliConveImpRelSec ;
   private int A3CliCod ;
   private int W3CliCod ;
   private int GX_INS218 ;
   private int W1896CliConveImpRelSec ;
   private java.math.BigDecimal AV18porUnaje ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private java.math.BigDecimal AV26CliConveImporte ;
   private java.math.BigDecimal W1589CliConveImporte ;
   private String AV11CliConvenio ;
   private String AV29que ;
   private String scmdbuf ;
   private String A1588CliConveImpTipo ;
   private String A1565CliConvenio ;
   private String W1565CliConvenio ;
   private String AV27CliConveImpTipo ;
   private String W1588CliConveImpTipo ;
   private String Gx_emsg ;
   private java.util.Date AV28origenCliConveImpVig ;
   private java.util.Date AV25CliConveImpVig ;
   private java.util.Date A1587CliConveImpVig ;
   private java.util.Date W1587CliConveImpVig ;
   private String A2045CliConveImpOld ;
   private String A2044CliConveImpRelRef ;
   private IDataStoreProvider pr_default ;
   private int[] P01P72_A1896CliConveImpRelSec ;
   private java.math.BigDecimal[] P01P72_A1589CliConveImporte ;
   private String[] P01P72_A1588CliConveImpTipo ;
   private java.util.Date[] P01P72_A1587CliConveImpVig ;
   private String[] P01P72_A1565CliConvenio ;
   private short[] P01P72_A1564CliPaiConve ;
   private int[] P01P72_A3CliCod ;
   private String[] P01P72_A2045CliConveImpOld ;
   private String[] P01P72_A2044CliConveImpRelRef ;
}

final  class ajustarimporteconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01P72", "SELECT CliConveImpRelSec, CliConveImporte, CliConveImpTipo, CliConveImpVig, CliConvenio, CliPaiConve, CliCod, CliConveImpOld, CliConveImpRelRef FROM clienteConvenio_importes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig  FOR UPDATE OF clienteConvenio_importes",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01P73", "SAVEPOINT gxupdate;INSERT INTO clienteConvenio_importes(CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo, CliConveImporte, CliConveImpRelSec, CliConveImpRelRef, CliConveImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01P74", "UPDATE clienteConvenio_importes SET CliConveImpRelSec=?, CliConveImporte=?  WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig = ? and CliConveImpTipo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 20);
               return;
      }
   }

}


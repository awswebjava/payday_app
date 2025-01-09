package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustarimporteadicional extends GXProcedure
{
   public ajustarimporteadicional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustarimporteadicional.class ), "" );
   }

   public ajustarimporteadicional( int remoteHandle ,
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
      ajustarimporteadicional.this.AV9CliCod = aP0;
      ajustarimporteadicional.this.AV10CliPaiConve = aP1;
      ajustarimporteadicional.this.AV11CliConvenio = aP2;
      ajustarimporteadicional.this.AV22origenConveAdiVig = aP3;
      ajustarimporteadicional.this.AV18porUnaje = aP4;
      ajustarimporteadicional.this.AV20ConveAdiVig = aP5;
      ajustarimporteadicional.this.AV25que = aP6;
      ajustarimporteadicional.this.AV26ConveAdiImpRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01M82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10CliPaiConve), AV11CliConvenio, AV22origenConveAdiVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2049ConveAdiImpOld = P01M82_A2049ConveAdiImpOld[0] ;
         A2059ConveAdiImpRelRef = P01M82_A2059ConveAdiImpRelRef[0] ;
         A1899ConveAdiImpRelSec = P01M82_A1899ConveAdiImpRelSec[0] ;
         A1000ConveAdiImporte = P01M82_A1000ConveAdiImporte[0] ;
         A999ConveAdiVig = P01M82_A999ConveAdiVig[0] ;
         A996ConveAdicod = P01M82_A996ConveAdicod[0] ;
         A1565CliConvenio = P01M82_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01M82_A1564CliPaiConve[0] ;
         A3CliCod = P01M82_A3CliCod[0] ;
         W3CliCod = A3CliCod ;
         W1564CliPaiConve = A1564CliPaiConve ;
         W1565CliConvenio = A1565CliConvenio ;
         if ( GXutil.strcmp(AV25que, httpContext.getMessage( "Truncar", "")) == 0 )
         {
            AV21ConveAdiImporte = GXutil.truncDecimal( A1000ConveAdiImporte.multiply(AV18porUnaje), 0) ;
         }
         else
         {
            if ( GXutil.strcmp(AV25que, httpContext.getMessage( "Redondear", "")) == 0 )
            {
               AV21ConveAdiImporte = GXutil.roundDecimal( A1000ConveAdiImporte.multiply(AV18porUnaje), 0) ;
            }
            else
            {
               if ( GXutil.strcmp(AV25que, httpContext.getMessage( "RedondearUp", "")) == 0 )
               {
                  AV21ConveAdiImporte = GXutil.roundToEven( A1000ConveAdiImporte.multiply(AV18porUnaje), 0) ;
               }
               else
               {
                  AV21ConveAdiImporte = A1000ConveAdiImporte.multiply(AV18porUnaje) ;
               }
            }
         }
         AV19ConveAdicod = A996ConveAdicod ;
         /*
            INSERT RECORD ON TABLE convenio_adicionalimportes

         */
         W3CliCod = A3CliCod ;
         W1564CliPaiConve = A1564CliPaiConve ;
         W1565CliConvenio = A1565CliConvenio ;
         W996ConveAdicod = A996ConveAdicod ;
         W999ConveAdiVig = A999ConveAdiVig ;
         W1000ConveAdiImporte = A1000ConveAdiImporte ;
         W1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
         W2049ConveAdiImpOld = A2049ConveAdiImpOld ;
         W2059ConveAdiImpRelRef = A2059ConveAdiImpRelRef ;
         A3CliCod = AV9CliCod ;
         A1564CliPaiConve = AV10CliPaiConve ;
         A1565CliConvenio = AV11CliConvenio ;
         A996ConveAdicod = AV19ConveAdicod ;
         A999ConveAdiVig = AV20ConveAdiVig ;
         A1000ConveAdiImporte = AV21ConveAdiImporte ;
         A1899ConveAdiImpRelSec = AV26ConveAdiImpRelSec ;
         A2049ConveAdiImpOld = "" ;
         A2059ConveAdiImpRelRef = "" ;
         /* Using cursor P01M83 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig, A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), A2059ConveAdiImpRelRef, A2049ConveAdiImpOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            /* Optimized UPDATE. */
            /* Using cursor P01M84 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV26ConveAdiImpRelSec), AV21ConveAdiImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
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
         A996ConveAdicod = W996ConveAdicod ;
         A999ConveAdiVig = W999ConveAdiVig ;
         A1000ConveAdiImporte = W1000ConveAdiImporte ;
         A1899ConveAdiImpRelSec = W1899ConveAdiImpRelSec ;
         A2049ConveAdiImpOld = W2049ConveAdiImpOld ;
         A2059ConveAdiImpRelRef = W2059ConveAdiImpRelRef ;
         /* End Insert */
         A3CliCod = W3CliCod ;
         A1564CliPaiConve = W1564CliPaiConve ;
         A1565CliConvenio = W1565CliConvenio ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ajustarimporteadicional");
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
      P01M82_A2049ConveAdiImpOld = new String[] {""} ;
      P01M82_A2059ConveAdiImpRelRef = new String[] {""} ;
      P01M82_A1899ConveAdiImpRelSec = new int[1] ;
      P01M82_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M82_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01M82_A996ConveAdicod = new String[] {""} ;
      P01M82_A1565CliConvenio = new String[] {""} ;
      P01M82_A1564CliPaiConve = new short[1] ;
      P01M82_A3CliCod = new int[1] ;
      A2049ConveAdiImpOld = "" ;
      A2059ConveAdiImpRelRef = "" ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A996ConveAdicod = "" ;
      A1565CliConvenio = "" ;
      W1565CliConvenio = "" ;
      AV21ConveAdiImporte = DecimalUtil.ZERO ;
      AV19ConveAdicod = "" ;
      W996ConveAdicod = "" ;
      W999ConveAdiVig = GXutil.nullDate() ;
      W1000ConveAdiImporte = DecimalUtil.ZERO ;
      W2049ConveAdiImpOld = "" ;
      W2059ConveAdiImpRelRef = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustarimporteadicional__default(),
         new Object[] {
             new Object[] {
            P01M82_A2049ConveAdiImpOld, P01M82_A2059ConveAdiImpRelRef, P01M82_A1899ConveAdiImpRelSec, P01M82_A1000ConveAdiImporte, P01M82_A999ConveAdiVig, P01M82_A996ConveAdicod, P01M82_A1565CliConvenio, P01M82_A1564CliPaiConve, P01M82_A3CliCod
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
   private int AV26ConveAdiImpRelSec ;
   private int A1899ConveAdiImpRelSec ;
   private int A3CliCod ;
   private int W3CliCod ;
   private int GX_INS208 ;
   private int W1899ConveAdiImpRelSec ;
   private java.math.BigDecimal AV18porUnaje ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private java.math.BigDecimal AV21ConveAdiImporte ;
   private java.math.BigDecimal W1000ConveAdiImporte ;
   private String AV11CliConvenio ;
   private String AV25que ;
   private String scmdbuf ;
   private String A996ConveAdicod ;
   private String A1565CliConvenio ;
   private String W1565CliConvenio ;
   private String AV19ConveAdicod ;
   private String W996ConveAdicod ;
   private String Gx_emsg ;
   private java.util.Date AV22origenConveAdiVig ;
   private java.util.Date AV20ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
   private java.util.Date W999ConveAdiVig ;
   private String A2049ConveAdiImpOld ;
   private String W2049ConveAdiImpOld ;
   private String A2059ConveAdiImpRelRef ;
   private String W2059ConveAdiImpRelRef ;
   private IDataStoreProvider pr_default ;
   private String[] P01M82_A2049ConveAdiImpOld ;
   private String[] P01M82_A2059ConveAdiImpRelRef ;
   private int[] P01M82_A1899ConveAdiImpRelSec ;
   private java.math.BigDecimal[] P01M82_A1000ConveAdiImporte ;
   private java.util.Date[] P01M82_A999ConveAdiVig ;
   private String[] P01M82_A996ConveAdicod ;
   private String[] P01M82_A1565CliConvenio ;
   private short[] P01M82_A1564CliPaiConve ;
   private int[] P01M82_A3CliCod ;
}

final  class ajustarimporteadicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01M82", "SELECT ConveAdiImpOld, ConveAdiImpRelRef, ConveAdiImpRelSec, ConveAdiImporte, ConveAdiVig, ConveAdicod, CliConvenio, CliPaiConve, CliCod FROM convenio_adicionalimportes WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (ConveAdiVig = ?) ORDER BY CliCod, CliPaiConve, CliConvenio  FOR UPDATE OF convenio_adicionalimportes",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01M83", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalimportes(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, ConveAdiImpRelRef, ConveAdiImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01M84", "UPDATE convenio_adicionalimportes SET ConveAdiImpRelSec=?, ConveAdiImporte=?  WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiVig = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
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
               stmt.setString(6, (String)parms[5], 20);
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
      }
   }

}


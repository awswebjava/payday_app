package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newescalasalarial extends GXProcedure
{
   public newescalasalarial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newescalasalarial.class ), "" );
   }

   public newescalasalarial( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             int aP7 )
   {
      newescalasalarial.this.AV16CliCod = aP0;
      newescalasalarial.this.AV15CliPaiConve = aP1;
      newescalasalarial.this.AV13CliConvenio = aP2;
      newescalasalarial.this.AV14CatCodigo = aP3;
      newescalasalarial.this.AV12CatVigencia = aP4;
      newescalasalarial.this.AV18EscBasico = aP5;
      newescalasalarial.this.AV19EscAdicional = aP6;
      newescalasalarial.this.AV17CatSalRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Categoriavalores1

      */
      A3CliCod = AV16CliCod ;
      A1564CliPaiConve = AV15CliPaiConve ;
      A1565CliConvenio = AV13CliConvenio ;
      A8CatCodigo = AV14CatCodigo ;
      A907CatVigencia = AV12CatVigencia ;
      A1891CatSalRelSec = AV17CatSalRelSec ;
      n1891CatSalRelSec = false ;
      A1892EscBasico = AV18EscBasico ;
      A1893EscAdicional = AV19EscAdicional ;
      A2042CatSalRelRef = "" ;
      A2043CatSalOld = "" ;
      /* Using cursor P01SF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, A1893EscAdicional, Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(A1891CatSalRelSec), A2042CatSalRelRef, A2043CatSalOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         n1891CatSalRelSec = false ;
         /* Optimized UPDATE. */
         /* Using cursor P01SF3 */
         pr_default.execute(1, new Object[] {AV19EscAdicional, AV18EscBasico, Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(AV17CatSalRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
         /* End optimized UPDATE. */
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newescalasalarial");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      A2042CatSalRelRef = "" ;
      A2043CatSalOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newescalasalarial__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV17CatSalRelSec ;
   private int GX_INS206 ;
   private int A3CliCod ;
   private int A1891CatSalRelSec ;
   private java.math.BigDecimal AV18EscBasico ;
   private java.math.BigDecimal AV19EscAdicional ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private String AV13CliConvenio ;
   private String AV14CatCodigo ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String Gx_emsg ;
   private java.util.Date AV12CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private boolean n1891CatSalRelSec ;
   private String A2043CatSalOld ;
   private String A2042CatSalRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newescalasalarial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01SF2", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, EscAdicional, CatSalRelSec, CatSalRelRef, CatSalOld, CatBasico, CatValorHora, CatAdicional, CatAdiHora) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01SF3", "UPDATE Categoriavalores1 SET EscAdicional=?, EscBasico=?, CatSalRelSec=?  WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(8, ((Number) parms[8]).intValue());
               }
               stmt.setVarchar(9, (String)parms[9], 40, false);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setString(6, (String)parms[6], 20);
               stmt.setString(7, (String)parms[7], 40);
               stmt.setDate(8, (java.util.Date)parms[8]);
               return;
      }
   }

}


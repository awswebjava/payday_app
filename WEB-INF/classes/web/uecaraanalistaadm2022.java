package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class uecaraanalistaadm2022 extends GXProcedure
{
   public uecaraanalistaadm2022( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( uecaraanalistaadm2022.class ), "" );
   }

   public uecaraanalistaadm2022( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      uecaraanalistaadm2022.this.AV8CliCod = aP0;
      uecaraanalistaadm2022.this.AV9CliPaiConve = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &CliPaiConve ", "")+GXutil.trim( GXutil.str( AV9CliPaiConve, 4, 0))) ;
      /*
         INSERT RECORD ON TABLE Categoriavalores1

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      GXt_char1 = A1565CliConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouecara(remoteHandle, context).execute( GXv_char2) ;
      uecaraanalistaadm2022.this.GXt_char1 = GXv_char2[0] ;
      A1565CliConvenio = GXt_char1 ;
      A8CatCodigo = httpContext.getMessage( "Centro_AnalisAdm", "") ;
      A2043CatSalOld = "" ;
      A2042CatSalRelRef = "" ;
      A907CatVigencia = localUtil.ymdtod( 2022, 8, 1) ;
      A1892EscBasico = DecimalUtil.doubleToDec(125060) ;
      /* Using cursor P01NG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, A2042CatSalRelRef, A2043CatSalOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Categoriavalores1

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      GXt_char1 = A1565CliConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouecara(remoteHandle, context).execute( GXv_char2) ;
      uecaraanalistaadm2022.this.GXt_char1 = GXv_char2[0] ;
      A1565CliConvenio = GXt_char1 ;
      A8CatCodigo = httpContext.getMessage( "Centro_AnalisAdm", "") ;
      A2043CatSalOld = "" ;
      A2042CatSalRelRef = "" ;
      A907CatVigencia = localUtil.ymdtod( 2022, 9, 1) ;
      A1892EscBasico = DecimalUtil.doubleToDec(137761) ;
      /* Using cursor P01NG3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, A2042CatSalRelRef, A2043CatSalOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
      if ( (pr_default.getStatus(1) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Categoriavalores1

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      GXt_char1 = A1565CliConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouecara(remoteHandle, context).execute( GXv_char2) ;
      uecaraanalistaadm2022.this.GXt_char1 = GXv_char2[0] ;
      A1565CliConvenio = GXt_char1 ;
      A8CatCodigo = httpContext.getMessage( "Centro_AnalisAdm", "") ;
      A2043CatSalOld = "" ;
      A2042CatSalRelRef = "" ;
      A907CatVigencia = localUtil.ymdtod( 2022, 10, 1) ;
      A1892EscBasico = DecimalUtil.doubleToDec(150463) ;
      /* Using cursor P01NG4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, A2042CatSalRelRef, A2043CatSalOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
      if ( (pr_default.getStatus(2) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Categoriavalores1

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      GXt_char1 = A1565CliConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouecara(remoteHandle, context).execute( GXv_char2) ;
      uecaraanalistaadm2022.this.GXt_char1 = GXv_char2[0] ;
      A1565CliConvenio = GXt_char1 ;
      A8CatCodigo = httpContext.getMessage( "Centro_AnalisAdm", "") ;
      A2043CatSalOld = "" ;
      A2042CatSalRelRef = "" ;
      A907CatVigencia = localUtil.ymdtod( 2022, 11, 1) ;
      A1892EscBasico = DecimalUtil.doubleToDec(162187) ;
      /* Using cursor P01NG5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, A2042CatSalRelRef, A2043CatSalOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
      if ( (pr_default.getStatus(3) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Categoriavalores1

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      GXt_char1 = A1565CliConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouecara(remoteHandle, context).execute( GXv_char2) ;
      uecaraanalistaadm2022.this.GXt_char1 = GXv_char2[0] ;
      A1565CliConvenio = GXt_char1 ;
      A8CatCodigo = httpContext.getMessage( "Centro_AnalisAdm", "") ;
      A2043CatSalOld = "" ;
      A2042CatSalRelRef = "" ;
      A907CatVigencia = localUtil.ymdtod( 2022, 12, 1) ;
      A1892EscBasico = DecimalUtil.doubleToDec(170003) ;
      /* Using cursor P01NG6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, A2042CatSalRelRef, A2043CatSalOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
      if ( (pr_default.getStatus(4) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
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
      Application.commitDataStores(context, remoteHandle, pr_default, "uecaraanalistaadm2022");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Pgmname = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A2043CatSalOld = "" ;
      A2042CatSalRelRef = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.uecaraanalistaadm2022__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV15Pgmname = "uecaraAnalistaAdm2022" ;
      /* GeneXus formulas. */
      AV15Pgmname = "uecaraAnalistaAdm2022" ;
      Gx_err = (short)(0) ;
   }

   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GX_INS206 ;
   private int A3CliCod ;
   private java.math.BigDecimal A1892EscBasico ;
   private String AV15Pgmname ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String Gx_emsg ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date A907CatVigencia ;
   private String A2043CatSalOld ;
   private String A2042CatSalRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class uecaraanalistaadm2022__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01NG2", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, CatSalRelRef, CatSalOld, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscAdicional, CatSalRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01NG3", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, CatSalRelRef, CatSalOld, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscAdicional, CatSalRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01NG4", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, CatSalRelRef, CatSalOld, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscAdicional, CatSalRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01NG5", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, CatSalRelRef, CatSalOld, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscAdicional, CatSalRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01NG6", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, CatSalRelRef, CatSalOld, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscAdicional, CatSalRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               return;
      }
   }

}


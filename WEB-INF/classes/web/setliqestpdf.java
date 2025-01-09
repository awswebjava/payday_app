package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqestpdf extends GXProcedure
{
   public setliqestpdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqestpdf.class ), "" );
   }

   public setliqestpdf( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      setliqestpdf.this.AV8CliCod = aP0;
      setliqestpdf.this.AV9EmpCod = aP1;
      setliqestpdf.this.AV10LiqNro = aP2;
      setliqestpdf.this.AV11LiqPDFEstado = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "CliCod: ", "")+GXutil.str( AV8CliCod, 6, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "EmpCod: ", "")+GXutil.str( AV9EmpCod, 4, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "LiqNro: ", "")+GXutil.str( AV10LiqNro, 8, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&&LiqPDFEstado: ", "")+AV11LiqPDFEstado) ;
      AV15GXLvl8 = (byte)(0) ;
      n2180LiqPDFEstado = false ;
      /* Optimized UPDATE. */
      /* Using cursor P029S2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(n2180LiqPDFEstado), AV11LiqPDFEstado, Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV15GXLvl8 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      if ( AV15GXLvl8 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqestpdf");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      A2180LiqPDFEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqestpdf__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV14Pgmname = "setLiqEstPDF" ;
      /* GeneXus formulas. */
      AV14Pgmname = "setLiqEstPDF" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl8 ;
   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private String AV11LiqPDFEstado ;
   private String AV14Pgmname ;
   private String A2180LiqPDFEstado ;
   private boolean n2180LiqPDFEstado ;
   private IDataStoreProvider pr_default ;
}

final  class setliqestpdf__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P029S2", "UPDATE Liquidacion SET LiqPDFEstado=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
      }
   }

}


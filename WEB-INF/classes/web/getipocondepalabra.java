package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getipocondepalabra extends GXProcedure
{
   public getipocondepalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getipocondepalabra.class ), "" );
   }

   public getipocondepalabra( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getipocondepalabra.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getipocondepalabra.this.AV8TipoConPalabra = aP0;
      getipocondepalabra.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&TipoConPalabra: \"", "")+AV8TipoConPalabra+"\"") ;
      AV13GXLvl3 = (byte)(0) ;
      /* Using cursor P020E2 */
      pr_default.execute(0, new Object[] {AV8TipoConPalabra});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2102TipoConPalabra = P020E2_A2102TipoConPalabra[0] ;
         A37TipoConCod = P020E2_A37TipoConCod[0] ;
         AV13GXLvl3 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "TipoConCod: \"", "")+A37TipoConCod+"\"") ;
         AV9TipoConCod = A37TipoConCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV13GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "none", "")) ;
      }
      if ( false )
      {
         new web.pendientesdeoptimizarcasesensitive(remoteHandle, context).execute( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getipocondepalabra.this.AV9TipoConCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9TipoConCod = "" ;
      AV12Pgmname = "" ;
      scmdbuf = "" ;
      P020E2_A2102TipoConPalabra = new String[] {""} ;
      P020E2_A37TipoConCod = new String[] {""} ;
      A2102TipoConPalabra = "" ;
      A37TipoConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getipocondepalabra__default(),
         new Object[] {
             new Object[] {
            P020E2_A2102TipoConPalabra, P020E2_A37TipoConCod
            }
         }
      );
      AV12Pgmname = "getIpoConDePalabra" ;
      /* GeneXus formulas. */
      AV12Pgmname = "getIpoConDePalabra" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl3 ;
   private short Gx_err ;
   private String AV8TipoConPalabra ;
   private String AV9TipoConCod ;
   private String AV12Pgmname ;
   private String scmdbuf ;
   private String A2102TipoConPalabra ;
   private String A37TipoConCod ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P020E2_A2102TipoConPalabra ;
   private String[] P020E2_A37TipoConCod ;
}

final  class getipocondepalabra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020E2", "SELECT TipoConPalabra, TipoConCod FROM TipoDeConcepto WHERE UPPER(RTRIM(LTRIM(TipoConPalabra))) = ( UPPER(RTRIM(LTRIM(?)))) ORDER BY TipoConCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}


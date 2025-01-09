package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esclienteusuario extends GXProcedure
{
   public esclienteusuario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esclienteusuario.class ), "" );
   }

   public esclienteusuario( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      esclienteusuario.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      esclienteusuario.this.AV8CliCod = aP0;
      esclienteusuario.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "hola", "")) ;
      /* Using cursor P01W62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01W62_A3CliCod[0] ;
         A1605ClienteConveniador = P01W62_A1605ClienteConveniador[0] ;
         A747ClienteSistema = P01W62_A747ClienteSistema[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, "1") ;
         if ( ! A747ClienteSistema && ! A1605ClienteConveniador )
         {
            AV9es = true ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, "2") ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.str( AV8CliCod, 6, 0)+httpContext.getMessage( " es ", "")+GXutil.trim( GXutil.booltostr( AV9es))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = esclienteusuario.this.AV9es;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Pgmname = "" ;
      scmdbuf = "" ;
      P01W62_A3CliCod = new int[1] ;
      P01W62_A1605ClienteConveniador = new boolean[] {false} ;
      P01W62_A747ClienteSistema = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.esclienteusuario__default(),
         new Object[] {
             new Object[] {
            P01W62_A3CliCod, P01W62_A1605ClienteConveniador, P01W62_A747ClienteSistema
            }
         }
      );
      AV12Pgmname = "WWPBaseObjects.esClienteUsuario" ;
      /* GeneXus formulas. */
      AV12Pgmname = "WWPBaseObjects.esClienteUsuario" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV12Pgmname ;
   private String scmdbuf ;
   private boolean AV9es ;
   private boolean A1605ClienteConveniador ;
   private boolean A747ClienteSistema ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P01W62_A3CliCod ;
   private boolean[] P01W62_A1605ClienteConveniador ;
   private boolean[] P01W62_A747ClienteSistema ;
}

final  class esclienteusuario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01W62", "SELECT CliCod, ClienteConveniador, ClienteSistema FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
               return;
      }
   }

}


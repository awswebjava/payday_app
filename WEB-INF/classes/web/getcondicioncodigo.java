package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondicioncodigo extends GXProcedure
{
   public getcondicioncodigo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondicioncodigo.class ), "" );
   }

   public getcondicioncodigo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getcondicioncodigo.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getcondicioncodigo.this.AV8CliCod = aP0;
      getcondicioncodigo.this.AV9ConCodigo = aP1;
      getcondicioncodigo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13GXLvl1 = (byte)(0) ;
      /* Using cursor P01IS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01IS2_A26ConCodigo[0] ;
         A3CliCod = P01IS2_A3CliCod[0] ;
         A954ConCondCodigo = P01IS2_A954ConCondCodigo[0] ;
         AV13GXLvl1 = (byte)(1) ;
         AV10ConCondCodigo = A954ConCondCodigo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV13GXLvl1 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "none cicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " concodigo \"", "")+AV9ConCodigo+"\"") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getcondicioncodigo.this.AV10ConCondCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCondCodigo = "" ;
      scmdbuf = "" ;
      P01IS2_A26ConCodigo = new String[] {""} ;
      P01IS2_A3CliCod = new int[1] ;
      P01IS2_A954ConCondCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      A954ConCondCodigo = "" ;
      AV14Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondicioncodigo__default(),
         new Object[] {
             new Object[] {
            P01IS2_A26ConCodigo, P01IS2_A3CliCod, P01IS2_A954ConCondCodigo
            }
         }
      );
      AV14Pgmname = "getCondicionCodigo" ;
      /* GeneXus formulas. */
      AV14Pgmname = "getCondicionCodigo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl1 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String AV10ConCondCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A954ConCondCodigo ;
   private String AV14Pgmname ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01IS2_A26ConCodigo ;
   private int[] P01IS2_A3CliCod ;
   private String[] P01IS2_A954ConCondCodigo ;
}

final  class getcondicioncodigo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IS2", "SELECT ConCodigo, CliCod, ConCondCodigo FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}


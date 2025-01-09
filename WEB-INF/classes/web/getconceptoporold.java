package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptoporold extends GXProcedure
{
   public getconceptoporold( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptoporold.class ), "" );
   }

   public getconceptoporold( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getconceptoporold.this.aP2 = new String[] {""};
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
      getconceptoporold.this.AV10CliCod = aP0;
      getconceptoporold.this.AV9ConCodOld = aP1;
      getconceptoporold.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00HQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9ConCodOld});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A469ConCodOld = P00HQ2_A469ConCodOld[0] ;
         A3CliCod = P00HQ2_A3CliCod[0] ;
         A26ConCodigo = P00HQ2_A26ConCodigo[0] ;
         AV8ConCodigo = A26ConCodigo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptoporold.this.AV8ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConCodigo = "" ;
      scmdbuf = "" ;
      P00HQ2_A469ConCodOld = new String[] {""} ;
      P00HQ2_A3CliCod = new int[1] ;
      P00HQ2_A26ConCodigo = new String[] {""} ;
      A469ConCodOld = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptoporold__default(),
         new Object[] {
             new Object[] {
            P00HQ2_A469ConCodOld, P00HQ2_A3CliCod, P00HQ2_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9ConCodOld ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A469ConCodOld ;
   private String A26ConCodigo ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00HQ2_A469ConCodOld ;
   private int[] P00HQ2_A3CliCod ;
   private String[] P00HQ2_A26ConCodigo ;
}

final  class getconceptoporold__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00HQ2", "SELECT ConCodOld, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (ConCodOld = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
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


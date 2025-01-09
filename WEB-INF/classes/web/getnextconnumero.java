package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextconnumero extends GXProcedure
{
   public getnextconnumero( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextconnumero.class ), "" );
   }

   public getnextconnumero( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 )
   {
      getnextconnumero.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             byte[] aP1 )
   {
      getnextconnumero.this.AV8CliCod = aP0;
      getnextconnumero.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02E42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02E42_A3CliCod[0] ;
         A1471ConNumero = P02E42_A1471ConNumero[0] ;
         A26ConCodigo = P02E42_A26ConCodigo[0] ;
         AV9ConNumero = A1471ConNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV9ConNumero = (byte)(AV9ConNumero+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnextconnumero.this.AV9ConNumero;
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
      P02E42_A3CliCod = new int[1] ;
      P02E42_A1471ConNumero = new byte[1] ;
      P02E42_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextconnumero__default(),
         new Object[] {
             new Object[] {
            P02E42_A3CliCod, P02E42_A1471ConNumero, P02E42_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9ConNumero ;
   private byte A1471ConNumero ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private byte[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P02E42_A3CliCod ;
   private byte[] P02E42_A1471ConNumero ;
   private String[] P02E42_A26ConCodigo ;
}

final  class getnextconnumero__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02E42", "SELECT CliCod, ConNumero, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConNumero DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
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
               return;
      }
   }

}


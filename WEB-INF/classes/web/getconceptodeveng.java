package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptodeveng extends GXProcedure
{
   public getconceptodeveng( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptodeveng.class ), "" );
   }

   public getconceptodeveng( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 )
   {
      getconceptodeveng.this.aP2 = new byte[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 )
   {
      getconceptodeveng.this.AV9CliCod = aP0;
      getconceptodeveng.this.AV8ConCodigo = aP1;
      getconceptodeveng.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01L42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01L42_A26ConCodigo[0] ;
         A3CliCod = P01L42_A3CliCod[0] ;
         A1539ConSacDeven = P01L42_A1539ConSacDeven[0] ;
         AV10ConSacDeven = A1539ConSacDeven ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptodeveng.this.AV10ConSacDeven;
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
      P01L42_A26ConCodigo = new String[] {""} ;
      P01L42_A3CliCod = new int[1] ;
      P01L42_A1539ConSacDeven = new byte[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptodeveng__default(),
         new Object[] {
             new Object[] {
            P01L42_A26ConCodigo, P01L42_A3CliCod, P01L42_A1539ConSacDeven
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10ConSacDeven ;
   private byte A1539ConSacDeven ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01L42_A26ConCodigo ;
   private int[] P01L42_A3CliCod ;
   private byte[] P01L42_A1539ConSacDeven ;
}

final  class getconceptodeveng__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01L42", "SELECT ConCodigo, CliCod, ConSacDeven FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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


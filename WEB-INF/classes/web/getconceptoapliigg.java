package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptoapliigg extends GXProcedure
{
   public getconceptoapliigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptoapliigg.class ), "" );
   }

   public getconceptoapliigg( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            String aP1 )
   {
      getconceptoapliigg.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short[] aP2 )
   {
      getconceptoapliigg.this.AV8CliCod = aP0;
      getconceptoapliigg.this.AV10ConCodigo = aP1;
      getconceptoapliigg.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01792 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV10ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01792_A26ConCodigo[0] ;
         A3CliCod = P01792_A3CliCod[0] ;
         A1112AplIIGG = P01792_A1112AplIIGG[0] ;
         n1112AplIIGG = P01792_n1112AplIIGG[0] ;
         AV9AplIIGG = A1112AplIIGG ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptoapliigg.this.AV9AplIIGG;
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
      P01792_A26ConCodigo = new String[] {""} ;
      P01792_A3CliCod = new int[1] ;
      P01792_A1112AplIIGG = new short[1] ;
      P01792_n1112AplIIGG = new boolean[] {false} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptoapliigg__default(),
         new Object[] {
             new Object[] {
            P01792_A26ConCodigo, P01792_A3CliCod, P01792_A1112AplIIGG, P01792_n1112AplIIGG
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean n1112AplIIGG ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01792_A26ConCodigo ;
   private int[] P01792_A3CliCod ;
   private short[] P01792_A1112AplIIGG ;
   private boolean[] P01792_n1112AplIIGG ;
}

final  class getconceptoapliigg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01792", "SELECT ConCodigo, CliCod, AplIIGG FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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


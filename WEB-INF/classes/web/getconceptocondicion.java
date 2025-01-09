package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptocondicion extends GXProcedure
{
   public getconceptocondicion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptocondicion.class ), "" );
   }

   public getconceptocondicion( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getconceptocondicion.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      getconceptocondicion.this.AV9CliCod = aP0;
      getconceptocondicion.this.AV8ConCodigo = aP1;
      getconceptocondicion.this.aP2 = aP2;
      getconceptocondicion.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01BO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01BO2_A26ConCodigo[0] ;
         A3CliCod = P01BO2_A3CliCod[0] ;
         A953ConCondicion = P01BO2_A953ConCondicion[0] ;
         n953ConCondicion = P01BO2_n953ConCondicion[0] ;
         A954ConCondCodigo = P01BO2_A954ConCondCodigo[0] ;
         AV10ConCondicion = A953ConCondicion ;
         AV11ConCondCodigo = A954ConCondCodigo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptocondicion.this.AV10ConCondicion;
      this.aP3[0] = getconceptocondicion.this.AV11ConCondCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCondicion = "" ;
      AV11ConCondCodigo = "" ;
      scmdbuf = "" ;
      P01BO2_A26ConCodigo = new String[] {""} ;
      P01BO2_A3CliCod = new int[1] ;
      P01BO2_A953ConCondicion = new String[] {""} ;
      P01BO2_n953ConCondicion = new boolean[] {false} ;
      P01BO2_A954ConCondCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptocondicion__default(),
         new Object[] {
             new Object[] {
            P01BO2_A26ConCodigo, P01BO2_A3CliCod, P01BO2_A953ConCondicion, P01BO2_n953ConCondicion, P01BO2_A954ConCondCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String AV10ConCondicion ;
   private String AV11ConCondCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private boolean n953ConCondicion ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BO2_A26ConCodigo ;
   private int[] P01BO2_A3CliCod ;
   private String[] P01BO2_A953ConCondicion ;
   private boolean[] P01BO2_n953ConCondicion ;
   private String[] P01BO2_A954ConCondCodigo ;
}

final  class getconceptocondicion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BO2", "SELECT ConCodigo, CliCod, ConCondicion, ConCondCodigo FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
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


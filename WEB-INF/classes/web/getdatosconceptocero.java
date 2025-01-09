package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosconceptocero extends GXProcedure
{
   public getdatosconceptocero( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosconceptocero.class ), "" );
   }

   public getdatosconceptocero( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              boolean[] aP2 )
   {
      getdatosconceptocero.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             boolean[] aP3 )
   {
      getdatosconceptocero.this.AV8CliCod = aP0;
      getdatosconceptocero.this.AV9ConCodigo = aP1;
      getdatosconceptocero.this.aP2 = aP2;
      getdatosconceptocero.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02E72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P02E72_A26ConCodigo[0] ;
         A3CliCod = P02E72_A3CliCod[0] ;
         A1068ConMostrarPos = P02E72_A1068ConMostrarPos[0] ;
         A1821ConErrorSiCero = P02E72_A1821ConErrorSiCero[0] ;
         AV11ConMostrarPos = A1068ConMostrarPos ;
         AV10ConErrorSiCero = A1821ConErrorSiCero ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdatosconceptocero.this.AV11ConMostrarPos;
      this.aP3[0] = getdatosconceptocero.this.AV10ConErrorSiCero;
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
      P02E72_A26ConCodigo = new String[] {""} ;
      P02E72_A3CliCod = new int[1] ;
      P02E72_A1068ConMostrarPos = new boolean[] {false} ;
      P02E72_A1821ConErrorSiCero = new boolean[] {false} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosconceptocero__default(),
         new Object[] {
             new Object[] {
            P02E72_A26ConCodigo, P02E72_A3CliCod, P02E72_A1068ConMostrarPos, P02E72_A1821ConErrorSiCero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV11ConMostrarPos ;
   private boolean AV10ConErrorSiCero ;
   private boolean A1068ConMostrarPos ;
   private boolean A1821ConErrorSiCero ;
   private boolean[] aP3 ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02E72_A26ConCodigo ;
   private int[] P02E72_A3CliCod ;
   private boolean[] P02E72_A1068ConMostrarPos ;
   private boolean[] P02E72_A1821ConErrorSiCero ;
}

final  class getdatosconceptocero__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02E72", "SELECT ConCodigo, CliCod, ConMostrarPos, ConErrorSiCero FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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


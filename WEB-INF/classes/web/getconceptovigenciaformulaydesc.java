package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptovigenciaformulaydesc extends GXProcedure
{
   public getconceptovigenciaformulaydesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptovigenciaformulaydesc.class ), "" );
   }

   public getconceptovigenciaformulaydesc( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             String[] aP3 )
   {
      getconceptovigenciaformulaydesc.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      getconceptovigenciaformulaydesc.this.AV10CliCod = aP0;
      getconceptovigenciaformulaydesc.this.AV9ConCodigo = aP1;
      getconceptovigenciaformulaydesc.this.aP2 = aP2;
      getconceptovigenciaformulaydesc.this.aP3 = aP3;
      getconceptovigenciaformulaydesc.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01Y82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01Y82_A26ConCodigo[0] ;
         A3CliCod = P01Y82_A3CliCod[0] ;
         A162ConVigencia = P01Y82_A162ConVigencia[0] ;
         A148ConFormula = P01Y82_A148ConFormula[0] ;
         n148ConFormula = P01Y82_n148ConFormula[0] ;
         A41ConDescrip = P01Y82_A41ConDescrip[0] ;
         AV8ConVigencia = A162ConVigencia ;
         AV12ConFormula = A148ConFormula ;
         AV11ConDescrip = A41ConDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptovigenciaformulaydesc.this.AV8ConVigencia;
      this.aP3[0] = getconceptovigenciaformulaydesc.this.AV12ConFormula;
      this.aP4[0] = getconceptovigenciaformulaydesc.this.AV11ConDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ConFormula = "" ;
      AV11ConDescrip = "" ;
      scmdbuf = "" ;
      P01Y82_A26ConCodigo = new String[] {""} ;
      P01Y82_A3CliCod = new int[1] ;
      P01Y82_A162ConVigencia = new byte[1] ;
      P01Y82_A148ConFormula = new String[] {""} ;
      P01Y82_n148ConFormula = new boolean[] {false} ;
      P01Y82_A41ConDescrip = new String[] {""} ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptovigenciaformulaydesc__default(),
         new Object[] {
             new Object[] {
            P01Y82_A26ConCodigo, P01Y82_A3CliCod, P01Y82_A162ConVigencia, P01Y82_A148ConFormula, P01Y82_n148ConFormula, P01Y82_A41ConDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8ConVigencia ;
   private byte A162ConVigencia ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean n148ConFormula ;
   private String AV12ConFormula ;
   private String A148ConFormula ;
   private String AV11ConDescrip ;
   private String A41ConDescrip ;
   private String[] aP4 ;
   private byte[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01Y82_A26ConCodigo ;
   private int[] P01Y82_A3CliCod ;
   private byte[] P01Y82_A162ConVigencia ;
   private String[] P01Y82_A148ConFormula ;
   private boolean[] P01Y82_n148ConFormula ;
   private String[] P01Y82_A41ConDescrip ;
}

final  class getconceptovigenciaformulaydesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Y82", "SELECT ConCodigo, CliCod, ConVigencia, ConFormula, ConDescrip FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
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


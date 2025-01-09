package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelveconceptosdeformula extends GXProcedure
{
   public devuelveconceptosdeformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelveconceptosdeformula.class ), "" );
   }

   public devuelveconceptosdeformula( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 String aP1 )
   {
      devuelveconceptosdeformula.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      devuelveconceptosdeformula.this.AV11CliCod = aP0;
      devuelveconceptosdeformula.this.AV12ConFormula = aP1;
      devuelveconceptosdeformula.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV15Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " empod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " conformula \"", "")+AV12ConFormula+"\"") ;
      AV16GXLvl3 = (byte)(0) ;
      /* Using cursor P02D22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV12ConFormula});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A148ConFormula = P02D22_A148ConFormula[0] ;
         n148ConFormula = P02D22_n148ConFormula[0] ;
         A3CliCod = P02D22_A3CliCod[0] ;
         A26ConCodigo = P02D22_A26ConCodigo[0] ;
         AV16GXLvl3 = (byte)(1) ;
         AV8ConCodigo.add(A26ConCodigo, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV16GXLvl3 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV15Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = devuelveconceptosdeformula.this.AV8ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      P02D22_A148ConFormula = new String[] {""} ;
      P02D22_n148ConFormula = new boolean[] {false} ;
      P02D22_A3CliCod = new int[1] ;
      P02D22_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.devuelveconceptosdeformula__default(),
         new Object[] {
             new Object[] {
            P02D22_A148ConFormula, P02D22_n148ConFormula, P02D22_A3CliCod, P02D22_A26ConCodigo
            }
         }
      );
      AV15Pgmname = "devuelveConceptosDeFormula" ;
      /* GeneXus formulas. */
      AV15Pgmname = "devuelveConceptosDeFormula" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16GXLvl3 ;
   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean n148ConFormula ;
   private String AV12ConFormula ;
   private String A148ConFormula ;
   private GXSimpleCollection<String>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02D22_A148ConFormula ;
   private boolean[] P02D22_n148ConFormula ;
   private int[] P02D22_A3CliCod ;
   private String[] P02D22_A26ConCodigo ;
   private GXSimpleCollection<String> AV8ConCodigo ;
}

final  class devuelveconceptosdeformula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02D22", "SELECT ConFormula, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (ConFormula = ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
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
               stmt.setLongVarchar(2, (String)parms[1]);
               return;
      }
   }

}


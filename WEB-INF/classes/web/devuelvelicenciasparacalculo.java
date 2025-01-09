package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelvelicenciasparacalculo extends GXProcedure
{
   public devuelvelicenciasparacalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelvelicenciasparacalculo.class ), "" );
   }

   public devuelvelicenciasparacalculo( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 )
   {
      devuelvelicenciasparacalculo.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      devuelvelicenciasparacalculo.this.AV10CliCod = aP0;
      devuelvelicenciasparacalculo.this.AV9PaiCod = aP1;
      devuelvelicenciasparacalculo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01R52 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A739SitLicCuentaTrab = P01R52_A739SitLicCuentaTrab[0] ;
         A916SitEsAusencia = P01R52_A916SitEsAusencia[0] ;
         A738SitEsLicencia = P01R52_A738SitEsLicencia[0] ;
         A1593SitPaiCod = P01R52_A1593SitPaiCod[0] ;
         n1593SitPaiCod = P01R52_n1593SitPaiCod[0] ;
         A16SitCodigo = P01R52_A16SitCodigo[0] ;
         AV8EmpBaseCod1.add(A16SitCodigo, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV8EmpBaseCod1.add(new web.estadoausenciasinjustificadas(remoteHandle, context).executeUdp( AV10CliCod), 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = devuelvelicenciasparacalculo.this.AV8EmpBaseCod1;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8EmpBaseCod1 = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P01R52_A739SitLicCuentaTrab = new boolean[] {false} ;
      P01R52_A916SitEsAusencia = new boolean[] {false} ;
      P01R52_A738SitEsLicencia = new boolean[] {false} ;
      P01R52_A1593SitPaiCod = new short[1] ;
      P01R52_n1593SitPaiCod = new boolean[] {false} ;
      P01R52_A16SitCodigo = new String[] {""} ;
      A16SitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.devuelvelicenciasparacalculo__default(),
         new Object[] {
             new Object[] {
            P01R52_A739SitLicCuentaTrab, P01R52_A916SitEsAusencia, P01R52_A738SitEsLicencia, P01R52_A1593SitPaiCod, P01R52_n1593SitPaiCod, P01R52_A16SitCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short A1593SitPaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A738SitEsLicencia ;
   private boolean n1593SitPaiCod ;
   private GXSimpleCollection<String>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01R52_A739SitLicCuentaTrab ;
   private boolean[] P01R52_A916SitEsAusencia ;
   private boolean[] P01R52_A738SitEsLicencia ;
   private short[] P01R52_A1593SitPaiCod ;
   private boolean[] P01R52_n1593SitPaiCod ;
   private String[] P01R52_A16SitCodigo ;
   private GXSimpleCollection<String> AV8EmpBaseCod1 ;
}

final  class devuelvelicenciasparacalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01R52", "SELECT SitLicCuentaTrab, SitEsAusencia, SitEsLicencia, SitPaiCod, SitCodigo FROM Estado WHERE (SitPaiCod = ?) AND (( SitEsLicencia = TRUE or SitEsAusencia = TRUE)) AND (SitLicCuentaTrab = TRUE) ORDER BY SitPaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


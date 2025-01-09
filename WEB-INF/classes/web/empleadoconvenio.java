package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadoconvenio extends GXProcedure
{
   public empleadoconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadoconvenio.class ), "" );
   }

   public empleadoconvenio( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      empleadoconvenio.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      empleadoconvenio.this.AV11CliCod = aP0;
      empleadoconvenio.this.AV12empcod = aP1;
      empleadoconvenio.this.AV8LegNumero = aP2;
      empleadoconvenio.this.AV10ConveCodigo = aP3;
      empleadoconvenio.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug5(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &empcod ", "")+GXutil.trim( GXutil.str( AV12empcod, 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV8LegNumero, 8, 0))+httpContext.getMessage( " convecodigo ", "")+GXutil.trim( AV10ConveCodigo)) ;
      AV9tieneConvenio = "0" ;
      /* Using cursor P004Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P004Q2_A6LegNumero[0] ;
         A1EmpCod = P004Q2_A1EmpCod[0] ;
         A3CliCod = P004Q2_A3CliCod[0] ;
         A937LegConveCodigo = P004Q2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P004Q2_n937LegConveCodigo[0] ;
         new web.msgdebug5(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "convecodigo ", "")+GXutil.upper( GXutil.trim( AV10ConveCodigo))+httpContext.getMessage( " caracterNulo ", "")+GXutil.upper( GXutil.trim( new web.caracternulo(remoteHandle, context).executeUdp( AV11CliCod)))) ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10ConveCodigo)), GXutil.upper( GXutil.trim( new web.caracternulo(remoteHandle, context).executeUdp( AV11CliCod)))) == 0 ) && P004Q2_n937LegConveCodigo[0] || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A937LegConveCodigo)), GXutil.upper( GXutil.trim( AV10ConveCodigo))) == 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV9tieneConvenio = "1" ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadoconvenio.this.AV9tieneConvenio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9tieneConvenio = "" ;
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      P004Q2_A6LegNumero = new int[1] ;
      P004Q2_A1EmpCod = new short[1] ;
      P004Q2_A3CliCod = new int[1] ;
      P004Q2_A937LegConveCodigo = new String[] {""} ;
      P004Q2_n937LegConveCodigo = new boolean[] {false} ;
      A937LegConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadoconvenio__default(),
         new Object[] {
             new Object[] {
            P004Q2_A6LegNumero, P004Q2_A1EmpCod, P004Q2_A3CliCod, P004Q2_A937LegConveCodigo, P004Q2_n937LegConveCodigo
            }
         }
      );
      AV15Pgmname = "EmpleadoConvenio" ;
      /* GeneXus formulas. */
      AV15Pgmname = "EmpleadoConvenio" ;
      Gx_err = (short)(0) ;
   }

   private short AV12empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10ConveCodigo ;
   private String AV9tieneConvenio ;
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean Cond_result ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P004Q2_A6LegNumero ;
   private short[] P004Q2_A1EmpCod ;
   private int[] P004Q2_A3CliCod ;
   private String[] P004Q2_A937LegConveCodigo ;
   private boolean[] P004Q2_n937LegConveCodigo ;
}

final  class empleadoconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004Q2", "SELECT LegNumero, EmpCod, CliCod, LegConveCodigo FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}


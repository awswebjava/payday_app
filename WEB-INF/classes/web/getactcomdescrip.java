package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getactcomdescrip extends GXProcedure
{
   public getactcomdescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getactcomdescrip.class ), "" );
   }

   public getactcomdescrip( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getactcomdescrip.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getactcomdescrip.this.AV9ActComCodigo = aP0;
      getactcomdescrip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P012Z2 */
      pr_default.execute(0, new Object[] {AV9ActComCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A903ActComCodigo = P012Z2_A903ActComCodigo[0] ;
         A904ActComDescripcion = P012Z2_A904ActComDescripcion[0] ;
         AV8ActComDescripcion = A904ActComDescripcion ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getactcomdescrip.this.AV8ActComDescripcion;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ActComDescripcion = "" ;
      scmdbuf = "" ;
      P012Z2_A903ActComCodigo = new String[] {""} ;
      P012Z2_A904ActComDescripcion = new String[] {""} ;
      A903ActComCodigo = "" ;
      A904ActComDescripcion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getactcomdescrip__default(),
         new Object[] {
             new Object[] {
            P012Z2_A903ActComCodigo, P012Z2_A904ActComDescripcion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9ActComCodigo ;
   private String scmdbuf ;
   private String A903ActComCodigo ;
   private String AV8ActComDescripcion ;
   private String A904ActComDescripcion ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P012Z2_A903ActComCodigo ;
   private String[] P012Z2_A904ActComDescripcion ;
}

final  class getactcomdescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012Z2", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial WHERE ActComCodigo = ( ?) ORDER BY ActComCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}


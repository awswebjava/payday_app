package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getactividad extends GXProcedure
{
   public getactividad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getactividad.class ), "" );
   }

   public getactividad( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getactividad.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      getactividad.this.AV8ActCodigo = aP0;
      getactividad.this.aP1 = aP1;
      getactividad.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AC2 */
      pr_default.execute(0, new Object[] {AV8ActCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A43ActCodigo = P00AC2_A43ActCodigo[0] ;
         A108ActDescrip = P00AC2_A108ActDescrip[0] ;
         AV9ActDescrip = A108ActDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getactividad.this.AV9ActDescrip;
      this.aP2[0] = getactividad.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ActDescrip = "" ;
      scmdbuf = "" ;
      P00AC2_A43ActCodigo = new String[] {""} ;
      P00AC2_A108ActDescrip = new String[] {""} ;
      A43ActCodigo = "" ;
      A108ActDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getactividad__default(),
         new Object[] {
             new Object[] {
            P00AC2_A43ActCodigo, P00AC2_A108ActDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ActCodigo ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private boolean AV11existe ;
   private String AV9ActDescrip ;
   private String A108ActDescrip ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AC2_A43ActCodigo ;
   private String[] P00AC2_A108ActDescrip ;
}

final  class getactividad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AC2", "SELECT ActCodigo, ActDescrip FROM Actividad WHERE ActCodigo = ( ?) ORDER BY ActCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
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
               stmt.setString(1, (String)parms[0], 8);
               return;
      }
   }

}


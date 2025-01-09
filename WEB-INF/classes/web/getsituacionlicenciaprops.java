package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsituacionlicenciaprops extends GXProcedure
{
   public getsituacionlicenciaprops( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsituacionlicenciaprops.class ), "" );
   }

   public getsituacionlicenciaprops( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              boolean[] aP1 ,
                              boolean[] aP2 ,
                              boolean[] aP3 ,
                              boolean[] aP4 ,
                              boolean[] aP5 ,
                              boolean[] aP6 )
   {
      getsituacionlicenciaprops.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 ,
                        boolean[] aP2 ,
                        boolean[] aP3 ,
                        boolean[] aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 ,
                             boolean[] aP2 ,
                             boolean[] aP3 ,
                             boolean[] aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 ,
                             boolean[] aP7 )
   {
      getsituacionlicenciaprops.this.AV10SitCodigo = aP0;
      getsituacionlicenciaprops.this.aP1 = aP1;
      getsituacionlicenciaprops.this.aP2 = aP2;
      getsituacionlicenciaprops.this.aP3 = aP3;
      getsituacionlicenciaprops.this.aP4 = aP4;
      getsituacionlicenciaprops.this.aP5 = aP5;
      getsituacionlicenciaprops.this.aP6 = aP6;
      getsituacionlicenciaprops.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00Q82 */
      pr_default.execute(0, new Object[] {AV10SitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P00Q82_A16SitCodigo[0] ;
         A738SitEsLicencia = P00Q82_A738SitEsLicencia[0] ;
         A739SitLicCuentaTrab = P00Q82_A739SitLicCuentaTrab[0] ;
         A916SitEsAusencia = P00Q82_A916SitEsAusencia[0] ;
         A1220SitAbsorbeFer = P00Q82_A1220SitAbsorbeFer[0] ;
         A1598EstadoSitRevista = P00Q82_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P00Q82_n1598EstadoSitRevista[0] ;
         A1807EstadoCanPresen = P00Q82_A1807EstadoCanPresen[0] ;
         A1809EstadoRemCorr = P00Q82_A1809EstadoRemCorr[0] ;
         AV9SitEsLicencia = A738SitEsLicencia ;
         AV8SitLicCuentaTrab = A739SitLicCuentaTrab ;
         AV11SitEsAusencia = A916SitEsAusencia ;
         AV13SitAbsorbeFer = A1220SitAbsorbeFer ;
         if ( ! (0==A1598EstadoSitRevista) )
         {
            AV12SitEsRevistaAFip = true ;
         }
         else
         {
            AV12SitEsRevistaAFip = false ;
         }
         AV14EstadoCanPresen = A1807EstadoCanPresen ;
         AV15EstadoRemCorr = A1809EstadoRemCorr ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsituacionlicenciaprops.this.AV9SitEsLicencia;
      this.aP2[0] = getsituacionlicenciaprops.this.AV11SitEsAusencia;
      this.aP3[0] = getsituacionlicenciaprops.this.AV8SitLicCuentaTrab;
      this.aP4[0] = getsituacionlicenciaprops.this.AV12SitEsRevistaAFip;
      this.aP5[0] = getsituacionlicenciaprops.this.AV13SitAbsorbeFer;
      this.aP6[0] = getsituacionlicenciaprops.this.AV14EstadoCanPresen;
      this.aP7[0] = getsituacionlicenciaprops.this.AV15EstadoRemCorr;
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
      P00Q82_A16SitCodigo = new String[] {""} ;
      P00Q82_A738SitEsLicencia = new boolean[] {false} ;
      P00Q82_A739SitLicCuentaTrab = new boolean[] {false} ;
      P00Q82_A916SitEsAusencia = new boolean[] {false} ;
      P00Q82_A1220SitAbsorbeFer = new boolean[] {false} ;
      P00Q82_A1598EstadoSitRevista = new short[1] ;
      P00Q82_n1598EstadoSitRevista = new boolean[] {false} ;
      P00Q82_A1807EstadoCanPresen = new boolean[] {false} ;
      P00Q82_A1809EstadoRemCorr = new boolean[] {false} ;
      A16SitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsituacionlicenciaprops__default(),
         new Object[] {
             new Object[] {
            P00Q82_A16SitCodigo, P00Q82_A738SitEsLicencia, P00Q82_A739SitLicCuentaTrab, P00Q82_A916SitEsAusencia, P00Q82_A1220SitAbsorbeFer, P00Q82_A1598EstadoSitRevista, P00Q82_n1598EstadoSitRevista, P00Q82_A1807EstadoCanPresen, P00Q82_A1809EstadoRemCorr
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1598EstadoSitRevista ;
   private short Gx_err ;
   private String AV10SitCodigo ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private boolean AV9SitEsLicencia ;
   private boolean AV11SitEsAusencia ;
   private boolean AV8SitLicCuentaTrab ;
   private boolean AV12SitEsRevistaAFip ;
   private boolean AV13SitAbsorbeFer ;
   private boolean AV14EstadoCanPresen ;
   private boolean AV15EstadoRemCorr ;
   private boolean A738SitEsLicencia ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A1220SitAbsorbeFer ;
   private boolean n1598EstadoSitRevista ;
   private boolean A1807EstadoCanPresen ;
   private boolean A1809EstadoRemCorr ;
   private boolean[] aP7 ;
   private boolean[] aP1 ;
   private boolean[] aP2 ;
   private boolean[] aP3 ;
   private boolean[] aP4 ;
   private boolean[] aP5 ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P00Q82_A16SitCodigo ;
   private boolean[] P00Q82_A738SitEsLicencia ;
   private boolean[] P00Q82_A739SitLicCuentaTrab ;
   private boolean[] P00Q82_A916SitEsAusencia ;
   private boolean[] P00Q82_A1220SitAbsorbeFer ;
   private short[] P00Q82_A1598EstadoSitRevista ;
   private boolean[] P00Q82_n1598EstadoSitRevista ;
   private boolean[] P00Q82_A1807EstadoCanPresen ;
   private boolean[] P00Q82_A1809EstadoRemCorr ;
}

final  class getsituacionlicenciaprops__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00Q82", "SELECT SitCodigo, SitEsLicencia, SitLicCuentaTrab, SitEsAusencia, SitAbsorbeFer, EstadoSitRevista, EstadoCanPresen, EstadoRemCorr FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}


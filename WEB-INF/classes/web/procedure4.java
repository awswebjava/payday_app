package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procedure4 extends GXProcedure
{
   public procedure4( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procedure4.class ), "" );
   }

   public procedure4( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      procedure4.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      /* Using cursor P00ZH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00ZH2_A3CliCod[0] ;
         A37TipoConCod = P00ZH2_A37TipoConCod[0] ;
         A38SubTipoConCod1 = P00ZH2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00ZH2_n38SubTipoConCod1[0] ;
         A41ConDescrip = P00ZH2_A41ConDescrip[0] ;
         A26ConCodigo = P00ZH2_A26ConCodigo[0] ;
         A895ConTipoOrden = P00ZH2_A895ConTipoOrden[0] ;
         AV9ConUsado = false ;
         GXt_boolean1 = AV11esConceptoImprimible ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.esconceptoimprimible(remoteHandle, context).execute( A37TipoConCod, GXv_boolean2) ;
         procedure4.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV11esConceptoImprimible = GXt_boolean1 ;
         if ( ( GXutil.strcmp(A38SubTipoConCod1, new web.subtipocalculoganancias(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(A38SubTipoConCod1, new web.subtipoganancias(remoteHandle, context).executeUdp( )) == 0 ) || ( AV11esConceptoImprimible ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV9ConUsado = true ;
         }
         else
         {
            GXv_boolean2[0] = AV13seUsa ;
            GXv_boolean3[0] = false ;
            GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem4[0] = AV12sdt_conceptos ;
            GXv_boolean5[0] = false ;
            new web.analizarconceptosuso(remoteHandle, context).execute( A3CliCod, (short)(0), 0, 0, A26ConCodigo, AV14TipoConCod, httpContext.getMessage( "TODOS", ""), true, true, false, GXv_boolean2, GXv_boolean3, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem4, GXv_boolean5) ;
            procedure4.this.AV13seUsa = GXv_boolean2[0] ;
            AV12sdt_conceptos = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem4[0] ;
            if ( AV13seUsa )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV9ConUsado = true ;
            }
         }
         if ( ! AV9ConUsado )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " condescrip ", "")+GXutil.trim( A41ConDescrip)+" "+GXutil.trim( GXutil.booltostr( AV9ConUsado))) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P00ZH2_A3CliCod = new int[1] ;
      P00ZH2_A37TipoConCod = new String[] {""} ;
      P00ZH2_A38SubTipoConCod1 = new String[] {""} ;
      P00ZH2_n38SubTipoConCod1 = new boolean[] {false} ;
      P00ZH2_A41ConDescrip = new String[] {""} ;
      P00ZH2_A26ConCodigo = new String[] {""} ;
      P00ZH2_A895ConTipoOrden = new short[1] ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A41ConDescrip = "" ;
      A26ConCodigo = "" ;
      AV14TipoConCod = "" ;
      GXv_boolean2 = new boolean[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV12sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem4 = new GXBaseCollection[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procedure4__default(),
         new Object[] {
             new Object[] {
            P00ZH2_A3CliCod, P00ZH2_A37TipoConCod, P00ZH2_A38SubTipoConCod1, P00ZH2_n38SubTipoConCod1, P00ZH2_A41ConDescrip, P00ZH2_A26ConCodigo, P00ZH2_A895ConTipoOrden
            }
         }
      );
      AV17Pgmname = "Procedure4" ;
      /* GeneXus formulas. */
      AV17Pgmname = "Procedure4" ;
      Gx_err = (short)(0) ;
   }

   private short A895ConTipoOrden ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A26ConCodigo ;
   private String AV14TipoConCod ;
   private boolean n38SubTipoConCod1 ;
   private boolean AV9ConUsado ;
   private boolean AV11esConceptoImprimible ;
   private boolean GXt_boolean1 ;
   private boolean Cond_result ;
   private boolean AV13seUsa ;
   private boolean GXv_boolean2[] ;
   private boolean GXv_boolean3[] ;
   private boolean GXv_boolean5[] ;
   private String A41ConDescrip ;
   private IDataStoreProvider pr_default ;
   private int[] P00ZH2_A3CliCod ;
   private String[] P00ZH2_A37TipoConCod ;
   private String[] P00ZH2_A38SubTipoConCod1 ;
   private boolean[] P00ZH2_n38SubTipoConCod1 ;
   private String[] P00ZH2_A41ConDescrip ;
   private String[] P00ZH2_A26ConCodigo ;
   private short[] P00ZH2_A895ConTipoOrden ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV12sdt_conceptos ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem4[] ;
}

final  class procedure4__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ZH2", "SELECT CliCod, TipoConCod, SubTipoConCod1, ConDescrip, ConCodigo, ConTipoOrden FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConTipoOrden, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((short[]) buf[6])[0] = rslt.getShort(6);
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
               return;
      }
   }

}


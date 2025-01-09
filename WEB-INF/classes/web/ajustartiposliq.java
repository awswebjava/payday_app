package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustartiposliq extends GXProcedure
{
   public ajustartiposliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustartiposliq.class ), "" );
   }

   public ajustartiposliq( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      ajustartiposliq.this.AV24parmCliCod = aP0;
      ajustartiposliq.this.AV23parmPaiCod = aP1;
      ajustartiposliq.this.AV16parmConCodigo = aP2;
      ajustartiposliq.this.AV26parmConCondicionPalabra = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV25parmConCondicion = AV26parmConCondicionPalabra ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "ini &&parmCliCod ", "")+GXutil.trim( GXutil.str( AV24parmCliCod, 6, 0))+httpContext.getMessage( " &parmConCodigo ", "")+AV16parmConCodigo+httpContext.getMessage( " &parmPaiCod ", "")+GXutil.trim( GXutil.str( AV23parmPaiCod, 4, 0))+httpContext.getMessage( " &parmConCondicion ", "")+AV25parmConCondicion+httpContext.getMessage( " &parmConCondicionPalabra ", "")+AV26parmConCondicionPalabra) ;
      if ( (0==AV24parmCliCod) )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV23parmPaiCod) ,
                                              Short.valueOf(A4CliPaiCod) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         /* Using cursor P01DA2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV23parmPaiCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A4CliPaiCod = P01DA2_A4CliPaiCod[0] ;
            n4CliPaiCod = P01DA2_n4CliPaiCod[0] ;
            A3CliCod = P01DA2_A3CliCod[0] ;
            AV20clientes.add((int)(A3CliCod), 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         AV20clientes.add((int)(AV24parmCliCod), 0);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&clientes count ", "")+GXutil.trim( GXutil.str( AV20clientes.size(), 9, 0))) ;
      AV21i = (short)(1) ;
      while ( AV21i <= AV20clientes.size() )
      {
         AV8CliCod = ((Number) AV20clientes.elementAt(-1+AV21i)).intValue() ;
         GXt_int1 = AV19PaiCod ;
         GXv_int2[0] = GXt_int1 ;
         new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
         ajustartiposliq.this.GXt_int1 = GXv_int2[0] ;
         AV19PaiCod = GXt_int1 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
         AV31GXLvl21 = (byte)(0) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              AV16parmConCodigo ,
                                              AV26parmConCondicionPalabra ,
                                              A26ConCodigo ,
                                              A953ConCondicion ,
                                              AV25parmConCondicion ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P01DA3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), AV16parmConCodigo, AV25parmConCondicion});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A953ConCondicion = P01DA3_A953ConCondicion[0] ;
            n953ConCondicion = P01DA3_n953ConCondicion[0] ;
            A26ConCodigo = P01DA3_A26ConCodigo[0] ;
            A3CliCod = P01DA3_A3CliCod[0] ;
            A510ConOrdEjec = P01DA3_A510ConOrdEjec[0] ;
            A40ConOrden = P01DA3_A40ConOrden[0] ;
            A162ConVigencia = P01DA3_A162ConVigencia[0] ;
            A150ConHabilitado = P01DA3_A150ConHabilitado[0] ;
            A37TipoConCod = P01DA3_A37TipoConCod[0] ;
            AV31GXLvl21 = (byte)(1) ;
            AV9ConCodigo = A26ConCodigo ;
            AV11ConOrdEjec = A510ConOrdEjec ;
            AV12ConOrden = A40ConOrden ;
            AV14ConCondicion = A953ConCondicion ;
            AV13ConVigencia = A162ConVigencia ;
            AV15ConHabilitado = A150ConHabilitado ;
            AV17TipoConCod = A37TipoConCod ;
            GXv_int3[0] = AV18condicion_segplano ;
            new web.getcondsegpla(remoteHandle, context).execute( A953ConCondicion, GXv_int3) ;
            ajustartiposliq.this.AV18condicion_segplano = GXv_int3[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&ConCodigo ", "")+A26ConCodigo) ;
            /* Execute user subroutine: 'TIPOS LIQ' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV31GXLvl21 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "whennone", "")) ;
         }
         AV21i = (short)(AV21i+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "fin", "")) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'TIPOS LIQ' Routine */
      returnInSub = false ;
      AV32GXLvl49 = (byte)(0) ;
      /* Using cursor P01DA4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A26ConCodigo = P01DA4_A26ConCodigo[0] ;
         A3CliCod = P01DA4_A3CliCod[0] ;
         A925ConTLiqSinCausa = P01DA4_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = P01DA4_n925ConTLiqSinCausa[0] ;
         A1406ConTLOrdejec = P01DA4_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = P01DA4_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = P01DA4_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = P01DA4_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = P01DA4_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01DA4_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = P01DA4_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = P01DA4_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01DA4_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = P01DA4_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = P01DA4_n1789CONTLSegPla[0] ;
         A32TLiqCod = P01DA4_A32TLiqCod[0] ;
         AV32GXLvl49 = (byte)(1) ;
         A1406ConTLOrdejec = AV11ConOrdEjec ;
         A1407ConTLConOrd = (short)(AV12ConOrden) ;
         A1409ConTLVigencia = AV13ConVigencia ;
         n1409ConTLVigencia = false ;
         A1410ConTLCondicion = AV14ConCondicion ;
         n1410ConTLCondicion = false ;
         A1470ConTLConHab = (byte)((byte)((AV15ConHabilitado)?1:0)) ;
         A1788ConTLTipoCon = AV17TipoConCod ;
         n1788ConTLTipoCon = false ;
         A1789CONTLSegPla = AV18condicion_segplano ;
         n1789CONTLSegPla = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "encuentra TLiqCod ", "")+GXutil.trim( A32TLiqCod)+httpContext.getMessage( " LE PUSO ", "")+GXutil.trim( GXutil.str( A1789CONTLSegPla, 1, 0))) ;
         /* Using cursor P01DA5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV32GXLvl49 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "nine", "")) ;
         if ( (GXutil.strcmp("", AV16parmConCodigo)==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "none", "")) ;
            /* Using cursor P01DA6 */
            pr_default.execute(4);
            while ( (pr_default.getStatus(4) != 101) )
            {
               A32TLiqCod = P01DA6_A32TLiqCod[0] ;
               A3CliCod = P01DA6_A3CliCod[0] ;
               AV10TLiqCod = A32TLiqCod ;
               if ( GXutil.strcmp(AV9ConCodigo, httpContext.getMessage( "DES001", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "JUBI 4 &TLiqCod ", "")+AV10TLiqCod) ;
               }
               /*
                  INSERT RECORD ON TABLE ConceptoTipoLiquidacion

               */
               W3CliCod = A3CliCod ;
               W32TLiqCod = A32TLiqCod ;
               A3CliCod = AV8CliCod ;
               A26ConCodigo = AV9ConCodigo ;
               A32TLiqCod = AV10TLiqCod ;
               A925ConTLiqSinCausa = false ;
               n925ConTLiqSinCausa = false ;
               A926ConTLiqSinPre = false ;
               n926ConTLiqSinPre = false ;
               A950ConTLTipEgr = "" ;
               A1406ConTLOrdejec = AV11ConOrdEjec ;
               A1407ConTLConOrd = (short)(AV12ConOrden) ;
               A1409ConTLVigencia = AV13ConVigencia ;
               n1409ConTLVigencia = false ;
               A1410ConTLCondicion = AV14ConCondicion ;
               n1410ConTLCondicion = false ;
               A1470ConTLConHab = (byte)((byte)((AV15ConHabilitado)?1:0)) ;
               A1788ConTLTipoCon = AV17TipoConCod ;
               n1788ConTLTipoCon = false ;
               A1789CONTLSegPla = AV18condicion_segplano ;
               n1789CONTLSegPla = false ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( " &TLiqCod ", "")+AV10TLiqCod+httpContext.getMessage( " &cliente ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " le puso ", "")+GXutil.trim( GXutil.str( A1789CONTLSegPla, 1, 0))) ;
               /* Using cursor P01DA7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod, Boolean.valueOf(n925ConTLiqSinCausa), Boolean.valueOf(A925ConTLiqSinCausa), Boolean.valueOf(n926ConTLiqSinPre), Boolean.valueOf(A926ConTLiqSinPre), A950ConTLTipEgr, Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
               if ( (pr_default.getStatus(5) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               A3CliCod = W3CliCod ;
               A32TLiqCod = W32TLiqCod ;
               /* End Insert */
               pr_default.readNext(4);
            }
            pr_default.close(4);
         }
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ajustartiposliq");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25parmConCondicion = "" ;
      AV29Pgmname = "" ;
      scmdbuf = "" ;
      P01DA2_A4CliPaiCod = new short[1] ;
      P01DA2_n4CliPaiCod = new boolean[] {false} ;
      P01DA2_A3CliCod = new int[1] ;
      AV20clientes = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_int2 = new short[1] ;
      A26ConCodigo = "" ;
      A953ConCondicion = "" ;
      P01DA3_A953ConCondicion = new String[] {""} ;
      P01DA3_n953ConCondicion = new boolean[] {false} ;
      P01DA3_A26ConCodigo = new String[] {""} ;
      P01DA3_A3CliCod = new int[1] ;
      P01DA3_A510ConOrdEjec = new long[1] ;
      P01DA3_A40ConOrden = new int[1] ;
      P01DA3_A162ConVigencia = new byte[1] ;
      P01DA3_A150ConHabilitado = new boolean[] {false} ;
      P01DA3_A37TipoConCod = new String[] {""} ;
      A37TipoConCod = "" ;
      AV9ConCodigo = "" ;
      AV14ConCondicion = "" ;
      AV17TipoConCod = "" ;
      GXv_int3 = new byte[1] ;
      A32TLiqCod = "" ;
      A950ConTLTipEgr = "" ;
      A1410ConTLCondicion = "" ;
      A1788ConTLTipoCon = "" ;
      P01DA4_A26ConCodigo = new String[] {""} ;
      P01DA4_A3CliCod = new int[1] ;
      P01DA4_A925ConTLiqSinCausa = new boolean[] {false} ;
      P01DA4_n925ConTLiqSinCausa = new boolean[] {false} ;
      P01DA4_A1406ConTLOrdejec = new long[1] ;
      P01DA4_A1407ConTLConOrd = new short[1] ;
      P01DA4_A1409ConTLVigencia = new byte[1] ;
      P01DA4_n1409ConTLVigencia = new boolean[] {false} ;
      P01DA4_A1410ConTLCondicion = new String[] {""} ;
      P01DA4_n1410ConTLCondicion = new boolean[] {false} ;
      P01DA4_A1470ConTLConHab = new byte[1] ;
      P01DA4_A1788ConTLTipoCon = new String[] {""} ;
      P01DA4_n1788ConTLTipoCon = new boolean[] {false} ;
      P01DA4_A1789CONTLSegPla = new byte[1] ;
      P01DA4_n1789CONTLSegPla = new boolean[] {false} ;
      P01DA4_A32TLiqCod = new String[] {""} ;
      P01DA6_A32TLiqCod = new String[] {""} ;
      P01DA6_A3CliCod = new int[1] ;
      AV10TLiqCod = "" ;
      W32TLiqCod = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustartiposliq__default(),
         new Object[] {
             new Object[] {
            P01DA2_A4CliPaiCod, P01DA2_n4CliPaiCod, P01DA2_A3CliCod
            }
            , new Object[] {
            P01DA3_A953ConCondicion, P01DA3_n953ConCondicion, P01DA3_A26ConCodigo, P01DA3_A3CliCod, P01DA3_A510ConOrdEjec, P01DA3_A40ConOrden, P01DA3_A162ConVigencia, P01DA3_A150ConHabilitado, P01DA3_A37TipoConCod
            }
            , new Object[] {
            P01DA4_A26ConCodigo, P01DA4_A3CliCod, P01DA4_A925ConTLiqSinCausa, P01DA4_n925ConTLiqSinCausa, P01DA4_A1406ConTLOrdejec, P01DA4_A1407ConTLConOrd, P01DA4_A1409ConTLVigencia, P01DA4_n1409ConTLVigencia, P01DA4_A1410ConTLCondicion, P01DA4_n1410ConTLCondicion,
            P01DA4_A1470ConTLConHab, P01DA4_A1788ConTLTipoCon, P01DA4_n1788ConTLTipoCon, P01DA4_A1789CONTLSegPla, P01DA4_n1789CONTLSegPla, P01DA4_A32TLiqCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01DA6_A32TLiqCod, P01DA6_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      AV29Pgmname = "ajustarTiposLiq" ;
      /* GeneXus formulas. */
      AV29Pgmname = "ajustarTiposLiq" ;
      Gx_err = (short)(0) ;
   }

   private byte AV31GXLvl21 ;
   private byte A162ConVigencia ;
   private byte AV13ConVigencia ;
   private byte AV18condicion_segplano ;
   private byte GXv_int3[] ;
   private byte A1789CONTLSegPla ;
   private byte A1409ConTLVigencia ;
   private byte A1470ConTLConHab ;
   private byte AV32GXLvl49 ;
   private short AV23parmPaiCod ;
   private short A4CliPaiCod ;
   private short AV21i ;
   private short AV19PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1407ConTLConOrd ;
   private short Gx_err ;
   private int AV24parmCliCod ;
   private int A3CliCod ;
   private int AV8CliCod ;
   private int A40ConOrden ;
   private int AV12ConOrden ;
   private int GX_INS8 ;
   private int W3CliCod ;
   private long A510ConOrdEjec ;
   private long AV11ConOrdEjec ;
   private long A1406ConTLOrdejec ;
   private String AV16parmConCodigo ;
   private String AV26parmConCondicionPalabra ;
   private String AV25parmConCondicion ;
   private String AV29Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A953ConCondicion ;
   private String A37TipoConCod ;
   private String AV9ConCodigo ;
   private String AV14ConCondicion ;
   private String AV17TipoConCod ;
   private String A32TLiqCod ;
   private String A950ConTLTipEgr ;
   private String A1410ConTLCondicion ;
   private String A1788ConTLTipoCon ;
   private String AV10TLiqCod ;
   private String W32TLiqCod ;
   private String Gx_emsg ;
   private boolean n4CliPaiCod ;
   private boolean n953ConCondicion ;
   private boolean A150ConHabilitado ;
   private boolean AV15ConHabilitado ;
   private boolean returnInSub ;
   private boolean A925ConTLiqSinCausa ;
   private boolean A926ConTLiqSinPre ;
   private boolean n925ConTLiqSinCausa ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1789CONTLSegPla ;
   private boolean n926ConTLiqSinPre ;
   private GXSimpleCollection<Integer> AV20clientes ;
   private IDataStoreProvider pr_default ;
   private short[] P01DA2_A4CliPaiCod ;
   private boolean[] P01DA2_n4CliPaiCod ;
   private int[] P01DA2_A3CliCod ;
   private String[] P01DA3_A953ConCondicion ;
   private boolean[] P01DA3_n953ConCondicion ;
   private String[] P01DA3_A26ConCodigo ;
   private int[] P01DA3_A3CliCod ;
   private long[] P01DA3_A510ConOrdEjec ;
   private int[] P01DA3_A40ConOrden ;
   private byte[] P01DA3_A162ConVigencia ;
   private boolean[] P01DA3_A150ConHabilitado ;
   private String[] P01DA3_A37TipoConCod ;
   private String[] P01DA4_A26ConCodigo ;
   private int[] P01DA4_A3CliCod ;
   private boolean[] P01DA4_A925ConTLiqSinCausa ;
   private boolean[] P01DA4_n925ConTLiqSinCausa ;
   private long[] P01DA4_A1406ConTLOrdejec ;
   private short[] P01DA4_A1407ConTLConOrd ;
   private byte[] P01DA4_A1409ConTLVigencia ;
   private boolean[] P01DA4_n1409ConTLVigencia ;
   private String[] P01DA4_A1410ConTLCondicion ;
   private boolean[] P01DA4_n1410ConTLCondicion ;
   private byte[] P01DA4_A1470ConTLConHab ;
   private String[] P01DA4_A1788ConTLTipoCon ;
   private boolean[] P01DA4_n1788ConTLTipoCon ;
   private byte[] P01DA4_A1789CONTLSegPla ;
   private boolean[] P01DA4_n1789CONTLSegPla ;
   private String[] P01DA4_A32TLiqCod ;
   private String[] P01DA6_A32TLiqCod ;
   private int[] P01DA6_A3CliCod ;
}

final  class ajustartiposliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01DA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV23parmPaiCod ,
                                          short A4CliPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliPaiCod, CliCod FROM Cliente" ;
      if ( ! (0==AV23parmPaiCod) )
      {
         addWhere(sWhereString, "(CliPaiCod = ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01DA3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV16parmConCodigo ,
                                          String AV26parmConCondicionPalabra ,
                                          String A26ConCodigo ,
                                          String A953ConCondicion ,
                                          String AV25parmConCondicion ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[3];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT ConCondicion, ConCodigo, CliCod, ConOrdEjec, ConOrden, ConVigencia, ConHabilitado, TipoConCod FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV16parmConCodigo)==0) )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV26parmConCondicionPalabra)==0) )
      {
         addWhere(sWhereString, "(ConCondicion = ( ?))");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01DA2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() );
            case 1 :
                  return conditional_P01DA3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01DA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DA3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DA4", "SELECT ConCodigo, CliCod, ConTLiqSinCausa, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  FOR UPDATE OF ConceptoTipoLiquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01DA5", "SAVEPOINT gxupdate;UPDATE ConceptoTipoLiquidacion SET ConTLOrdejec=?, ConTLConOrd=?, ConTLVigencia=?, ConTLCondicion=?, ConTLConHab=?, ConTLTipoCon=?, CONTLSegPla=?  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01DA6", "SELECT TLiqCod, CliCod FROM TipoLiquidacion ORDER BY CliCod, TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01DA7", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((long[]) buf[4])[0] = rslt.getLong(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(11, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[5], 20);
               }
               stmt.setByte(5, ((Number) parms[6]).byteValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[8], 20);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(7, ((Number) parms[10]).byteValue());
               }
               stmt.setInt(8, ((Number) parms[11]).intValue());
               stmt.setString(9, (String)parms[12], 10);
               stmt.setString(10, (String)parms[13], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               }
               stmt.setString(6, (String)parms[7], 20);
               stmt.setLong(7, ((Number) parms[8]).longValue());
               stmt.setShort(8, ((Number) parms[9]).shortValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[11]).byteValue());
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[13], 20);
               }
               stmt.setByte(11, ((Number) parms[14]).byteValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[16], 20);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(13, ((Number) parms[18]).byteValue());
               }
               return;
      }
   }

}


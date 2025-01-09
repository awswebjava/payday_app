package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_retPerPago extends GxUserType
{
   public Sdtpresentacion_1_18_retPerPago( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_retPerPago.class));
   }

   public Sdtpresentacion_1_18_retPerPago( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_retPerPago");
   }

   public Sdtpresentacion_1_18_retPerPago( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_retPerPago");
   }

   public Sdtpresentacion_1_18_retPerPago( StructSdtpresentacion_1_18_retPerPago struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      if ( oReader.existsAttribute("tipo") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_retPerPago_Tipo = oReader.getAttributeByName("tipo") ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipoDoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nroDoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "denominacion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descBasica") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descAdicional") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "montoTotal") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_retPerPago_Montototal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "periodos") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_retPerPago_Periodos == null )
               {
                  gxTv_Sdtpresentacion_1_18_retPerPago_Periodos = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo>(web.Sdtpresentacion_1_18_retPerPago_periodo.class, "presentacion_1_18.retPerPago.periodo", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_retPerPago_Periodos.readxmlcollection(oReader, "periodos", "periodo") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "periodos") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detalles") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_retPerPago_Detalles == null )
               {
                  gxTv_Sdtpresentacion_1_18_retPerPago_Detalles = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle>(web.Sdtpresentacion_1_18_retPerPago_detalle.class, "presentacion_1_18.retPerPago.detalle", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_retPerPago_Detalles.readxmlcollection(oReader, "detalles", "detalle") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "detalles") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "presentacion_1_18.retPerPago" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeAttribute("tipo", gxTv_Sdtpresentacion_1_18_retPerPago_Tipo);
      oWriter.writeElement("tipoDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nroDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("denominacion", gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("descBasica", gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("descAdicional", gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("montoTotal", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_retPerPago_Montototal, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Periodos != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_Sdtpresentacion_1_18_retPerPago_Periodos.writexmlcollection(oWriter, "periodos", sNameSpace1, "periodo", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Detalles != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_Sdtpresentacion_1_18_retPerPago_Detalles.writexmlcollection(oWriter, "detalles", sNameSpace1, "detalle", "");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("tipo", gxTv_Sdtpresentacion_1_18_retPerPago_Tipo, false, false);
      AddObjectProperty("tipoDoc", gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc, false, false);
      AddObjectProperty("nroDoc", gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc, false, false);
      AddObjectProperty("denominacion", gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion, false, false);
      AddObjectProperty("descBasica", gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica, false, false);
      AddObjectProperty("descAdicional", gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional, false, false);
      AddObjectProperty("montoTotal", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_retPerPago_Montototal, 18, 2)), false, false);
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Periodos != null )
      {
         AddObjectProperty("periodos", gxTv_Sdtpresentacion_1_18_retPerPago_Periodos, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Detalles != null )
      {
         AddObjectProperty("detalles", gxTv_Sdtpresentacion_1_18_retPerPago_Detalles, false, false);
      }
   }

   public String getgxTv_Sdtpresentacion_1_18_retPerPago_Tipo( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Tipo ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Tipo( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Tipo = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc = value ;
   }

   public long getgxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc( long value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_retPerPago_Denominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Denominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_retPerPago_Descbasica( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Descbasica( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_retPerPago_Descadicional( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Descadicional( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_retPerPago_Montototal( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Montototal ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Montototal( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Montototal = value ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo> getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos( )
   {
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Periodos == null )
      {
         gxTv_Sdtpresentacion_1_18_retPerPago_Periodos = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo>(web.Sdtpresentacion_1_18_retPerPago_periodo.class, "presentacion_1_18.retPerPago.periodo", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_retPerPago_Periodos ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Periodos( GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo> value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Periodos_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Periodos == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle> getgxTv_Sdtpresentacion_1_18_retPerPago_Detalles( )
   {
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Detalles == null )
      {
         gxTv_Sdtpresentacion_1_18_retPerPago_Detalles = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle>(web.Sdtpresentacion_1_18_retPerPago_detalle.class, "presentacion_1_18.retPerPago.detalle", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_retPerPago_Detalles ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Detalles( GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle> value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_Detalles_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_retPerPago_Detalles_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_retPerPago_Detalles == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Tipo = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Montototal = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_N ;
   }

   public web.Sdtpresentacion_1_18_retPerPago Clone( )
   {
      return (web.Sdtpresentacion_1_18_retPerPago)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_retPerPago struct )
   {
      setgxTv_Sdtpresentacion_1_18_retPerPago_Tipo(struct.getTipo());
      setgxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc(struct.getTipodoc());
      setgxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc(struct.getNrodoc());
      setgxTv_Sdtpresentacion_1_18_retPerPago_Denominacion(struct.getDenominacion());
      setgxTv_Sdtpresentacion_1_18_retPerPago_Descbasica(struct.getDescbasica());
      setgxTv_Sdtpresentacion_1_18_retPerPago_Descadicional(struct.getDescadicional());
      setgxTv_Sdtpresentacion_1_18_retPerPago_Montototal(struct.getMontototal());
      GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo> gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo>(web.Sdtpresentacion_1_18_retPerPago_periodo.class, "presentacion_1_18.retPerPago.periodo", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_retPerPago_periodo> gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux1 = struct.getPeriodos();
      if (gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux.add(new web.Sdtpresentacion_1_18_retPerPago_periodo(gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_retPerPago_Periodos(gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle> gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle>(web.Sdtpresentacion_1_18_retPerPago_detalle.class, "presentacion_1_18.retPerPago.detalle", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_retPerPago_detalle> gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux1 = struct.getDetalles();
      if (gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux.add(new web.Sdtpresentacion_1_18_retPerPago_detalle(gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_retPerPago_Detalles(gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_retPerPago getStruct( )
   {
      web.StructSdtpresentacion_1_18_retPerPago struct = new web.StructSdtpresentacion_1_18_retPerPago ();
      struct.setTipo(getgxTv_Sdtpresentacion_1_18_retPerPago_Tipo());
      struct.setTipodoc(getgxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc());
      struct.setNrodoc(getgxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc());
      struct.setDenominacion(getgxTv_Sdtpresentacion_1_18_retPerPago_Denominacion());
      struct.setDescbasica(getgxTv_Sdtpresentacion_1_18_retPerPago_Descbasica());
      struct.setDescadicional(getgxTv_Sdtpresentacion_1_18_retPerPago_Descadicional());
      struct.setMontototal(getgxTv_Sdtpresentacion_1_18_retPerPago_Montototal());
      struct.setPeriodos(getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos().getStruct());
      struct.setDetalles(getgxTv_Sdtpresentacion_1_18_retPerPago_Detalles().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_N ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_retPerPago_Montototal ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Tipo ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo> gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle> gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_periodo> gxTv_Sdtpresentacion_1_18_retPerPago_Periodos=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago_detalle> gxTv_Sdtpresentacion_1_18_retPerPago_Detalles=null ;
}


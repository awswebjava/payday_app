package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_ajuste extends GxUserType
{
   public Sdtpresentacion_1_18_ajuste( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_ajuste.class));
   }

   public Sdtpresentacion_1_18_ajuste( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_ajuste");
   }

   public Sdtpresentacion_1_18_ajuste( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_ajuste");
   }

   public Sdtpresentacion_1_18_ajuste( StructSdtpresentacion_1_18_ajuste struct )
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
         gxTv_Sdtpresentacion_1_18_ajuste_Tipo = oReader.getAttributeByName("tipo") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "cuit") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_ajuste_Cuit = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "denominacion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_ajuste_Denominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descBasica") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_ajuste_Descbasica = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descAdicional") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_ajuste_Descadicional = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "montoTotal") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_ajuste_Montototal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detalles") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_ajuste_Detalles == null )
               {
                  gxTv_Sdtpresentacion_1_18_ajuste_Detalles = new GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle>(web.Sdtpresentacion_1_18_ajuste_detalle.class, "presentacion_1_18.ajuste.detalle", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_ajuste_Detalles.readxmlcollection(oReader, "detalles", "detalle") ;
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
         sName = "presentacion_1_18.ajuste" ;
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
      oWriter.writeAttribute("tipo", gxTv_Sdtpresentacion_1_18_ajuste_Tipo);
      oWriter.writeElement("cuit", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_ajuste_Cuit, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("denominacion", gxTv_Sdtpresentacion_1_18_ajuste_Denominacion);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("descBasica", gxTv_Sdtpresentacion_1_18_ajuste_Descbasica);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("descAdicional", gxTv_Sdtpresentacion_1_18_ajuste_Descadicional);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("montoTotal", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_ajuste_Montototal, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_ajuste_Detalles != null )
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
         gxTv_Sdtpresentacion_1_18_ajuste_Detalles.writexmlcollection(oWriter, "detalles", sNameSpace1, "detalle", "");
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
      AddObjectProperty("tipo", gxTv_Sdtpresentacion_1_18_ajuste_Tipo, false, false);
      AddObjectProperty("cuit", gxTv_Sdtpresentacion_1_18_ajuste_Cuit, false, false);
      AddObjectProperty("denominacion", gxTv_Sdtpresentacion_1_18_ajuste_Denominacion, false, false);
      AddObjectProperty("descBasica", gxTv_Sdtpresentacion_1_18_ajuste_Descbasica, false, false);
      AddObjectProperty("descAdicional", gxTv_Sdtpresentacion_1_18_ajuste_Descadicional, false, false);
      AddObjectProperty("montoTotal", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_ajuste_Montototal, 18, 2)), false, false);
      if ( gxTv_Sdtpresentacion_1_18_ajuste_Detalles != null )
      {
         AddObjectProperty("detalles", gxTv_Sdtpresentacion_1_18_ajuste_Detalles, false, false);
      }
   }

   public String getgxTv_Sdtpresentacion_1_18_ajuste_Tipo( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Tipo ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Tipo( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Tipo = value ;
   }

   public long getgxTv_Sdtpresentacion_1_18_ajuste_Cuit( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Cuit ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Cuit( long value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Cuit = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_ajuste_Denominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Denominacion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Denominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Denominacion = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_ajuste_Descbasica( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Descbasica ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Descbasica( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descbasica = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_ajuste_Descadicional( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Descadicional ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Descadicional( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descadicional = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_ajuste_Montototal( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Montototal ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Montototal( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Montototal = value ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle> getgxTv_Sdtpresentacion_1_18_ajuste_Detalles( )
   {
      if ( gxTv_Sdtpresentacion_1_18_ajuste_Detalles == null )
      {
         gxTv_Sdtpresentacion_1_18_ajuste_Detalles = new GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle>(web.Sdtpresentacion_1_18_ajuste_detalle.class, "presentacion_1_18.ajuste.detalle", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_ajuste_Detalles ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Detalles( GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle> value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_ajuste_Detalles_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_ajuste_Detalles_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_ajuste_Detalles == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_ajuste_Detalles_N( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_Tipo = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descbasica = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descadicional = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Montototal = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_N ;
   }

   public web.Sdtpresentacion_1_18_ajuste Clone( )
   {
      return (web.Sdtpresentacion_1_18_ajuste)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_ajuste struct )
   {
      setgxTv_Sdtpresentacion_1_18_ajuste_Tipo(struct.getTipo());
      setgxTv_Sdtpresentacion_1_18_ajuste_Cuit(struct.getCuit());
      setgxTv_Sdtpresentacion_1_18_ajuste_Denominacion(struct.getDenominacion());
      setgxTv_Sdtpresentacion_1_18_ajuste_Descbasica(struct.getDescbasica());
      setgxTv_Sdtpresentacion_1_18_ajuste_Descadicional(struct.getDescadicional());
      setgxTv_Sdtpresentacion_1_18_ajuste_Montototal(struct.getMontototal());
      GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle> gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle>(web.Sdtpresentacion_1_18_ajuste_detalle.class, "presentacion_1_18.ajuste.detalle", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_ajuste_detalle> gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux1 = struct.getDetalles();
      if (gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux.add(new web.Sdtpresentacion_1_18_ajuste_detalle(gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_ajuste_Detalles(gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_ajuste getStruct( )
   {
      web.StructSdtpresentacion_1_18_ajuste struct = new web.StructSdtpresentacion_1_18_ajuste ();
      struct.setTipo(getgxTv_Sdtpresentacion_1_18_ajuste_Tipo());
      struct.setCuit(getgxTv_Sdtpresentacion_1_18_ajuste_Cuit());
      struct.setDenominacion(getgxTv_Sdtpresentacion_1_18_ajuste_Denominacion());
      struct.setDescbasica(getgxTv_Sdtpresentacion_1_18_ajuste_Descbasica());
      struct.setDescadicional(getgxTv_Sdtpresentacion_1_18_ajuste_Descadicional());
      struct.setMontototal(getgxTv_Sdtpresentacion_1_18_ajuste_Montototal());
      struct.setDetalles(getgxTv_Sdtpresentacion_1_18_ajuste_Detalles().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_ajuste_N ;
   protected byte gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtpresentacion_1_18_ajuste_Cuit ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_ajuste_Montototal ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Tipo ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Denominacion ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Descbasica ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Descadicional ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle> gxTv_Sdtpresentacion_1_18_ajuste_Detalles_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_ajuste_detalle> gxTv_Sdtpresentacion_1_18_ajuste_Detalles=null ;
}


package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_breadCrumb_sdt_breadCrumbItem extends GxUserType
{
   public Sdtsdt_breadCrumb_sdt_breadCrumbItem( )
   {
      this(  new ModelContext(Sdtsdt_breadCrumb_sdt_breadCrumbItem.class));
   }

   public Sdtsdt_breadCrumb_sdt_breadCrumbItem( ModelContext context )
   {
      super( context, "Sdtsdt_breadCrumb_sdt_breadCrumbItem");
   }

   public Sdtsdt_breadCrumb_sdt_breadCrumbItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_breadCrumb_sdt_breadCrumbItem");
   }

   public Sdtsdt_breadCrumb_sdt_breadCrumbItem( StructSdtsdt_breadCrumb_sdt_breadCrumbItem struct )
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
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuOpcTitulo") )
            {
               gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "URL") )
            {
               gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nivel") )
            {
               gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuOpcCod") )
            {
               gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "sdt_breadCrumb.sdt_breadCrumbItem" ;
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
      oWriter.writeElement("MenuOpcTitulo", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("URL", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("nivel", GXutil.trim( GXutil.str( gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MenuOpcCod", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("MenuOpcTitulo", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo, false, false);
      AddObjectProperty("URL", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url, false, false);
      AddObjectProperty("nivel", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel, false, false);
      AddObjectProperty("MenuOpcCod", gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod, false, false);
   }

   public String getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo ;
   }

   public void setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( String value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo = value ;
   }

   public String getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url ;
   }

   public void setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url( String value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url = value ;
   }

   public short getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel ;
   }

   public void setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel( short value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel = value ;
   }

   public String getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod ;
   }

   public void setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod( String value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo = "" ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(1) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url = "" ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N ;
   }

   public web.Sdtsdt_breadCrumb_sdt_breadCrumbItem Clone( )
   {
      return (web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_breadCrumb_sdt_breadCrumbItem struct )
   {
      setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo(struct.getMenuopctitulo());
      setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url(struct.getUrl());
      setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel(struct.getNivel());
      setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod(struct.getMenuopccod());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_breadCrumb_sdt_breadCrumbItem getStruct( )
   {
      web.StructSdtsdt_breadCrumb_sdt_breadCrumbItem struct = new web.StructSdtsdt_breadCrumb_sdt_breadCrumbItem ();
      struct.setMenuopctitulo(getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo());
      struct.setUrl(getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url());
      struct.setNivel(getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel());
      struct.setMenuopccod(getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N ;
   protected short gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo ;
   protected String gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url ;
   protected String gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod ;
}


package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem extends GxUserType
{
   public Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem( )
   {
      this(  new ModelContext(Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem.class));
   }

   public Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem( ModelContext context )
   {
      super( context, "Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem");
   }

   public Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem( int remoteHandle ,
                                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem");
   }

   public Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem( StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatCodigo") )
            {
               gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvCod") )
            {
               gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatPaiCod") )
            {
               gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_CategoriaProvincia.sdt_CategoriaProvinciaItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatCodigo", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatProvCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatPaiCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod, 4, 0)));
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
      AddObjectProperty("CliPaiConve", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio, false, false);
      AddObjectProperty("CatCodigo", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo, false, false);
      AddObjectProperty("CatProvCod", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod, false, false);
      AddObjectProperty("CatPaiCod", gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod, false, false);
   }

   public short getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve ;
   }

   public void setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve( short value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve = value ;
   }

   public String getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio ;
   }

   public void setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio( String value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio = value ;
   }

   public String getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo ;
   }

   public void setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo( String value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo = value ;
   }

   public short getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod ;
   }

   public void setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod( short value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod = value ;
   }

   public short getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod ;
   }

   public void setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod( short value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(1) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio = "" ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N ;
   }

   public web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem Clone( )
   {
      return (web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem struct )
   {
      setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo(struct.getCatcodigo());
      setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod(struct.getCatprovcod());
      setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod(struct.getCatpaicod());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem getStruct( )
   {
      web.StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem struct = new web.StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem ();
      struct.setClipaiconve(getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio());
      struct.setCatcodigo(getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo());
      struct.setCatprovcod(getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod());
      struct.setCatpaicod(getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N ;
   protected short gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve ;
   protected short gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod ;
   protected short gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio ;
   protected String gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}


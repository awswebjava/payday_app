package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_conceptos_sdt_conceptosItem extends GxUserType
{
   public Sdtsdt_conceptos_sdt_conceptosItem( )
   {
      this(  new ModelContext(Sdtsdt_conceptos_sdt_conceptosItem.class));
   }

   public Sdtsdt_conceptos_sdt_conceptosItem( ModelContext context )
   {
      super( context, "Sdtsdt_conceptos_sdt_conceptosItem");
   }

   public Sdtsdt_conceptos_sdt_conceptosItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_conceptos_sdt_conceptosItem");
   }

   public Sdtsdt_conceptos_sdt_conceptosItem( StructSdtsdt_conceptos_sdt_conceptosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "concodigo") )
            {
               gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "yaRecorrido") )
            {
               gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip") )
            {
               gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "esImprimible") )
            {
               gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "directo") )
            {
               gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EsConcepto") )
            {
               gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "sdt_conceptos.sdt_conceptosItem" ;
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
      oWriter.writeElement("concodigo", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("yaRecorrido", GXutil.booltostr( gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescrip", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("esImprimible", GXutil.booltostr( gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("directo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EsConcepto", GXutil.booltostr( gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto));
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
      AddObjectProperty("concodigo", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo, false, false);
      AddObjectProperty("yaRecorrido", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido, false, false);
      AddObjectProperty("ConDescrip", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip, false, false);
      AddObjectProperty("esImprimible", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible, false, false);
      AddObjectProperty("directo", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo, false, false);
      AddObjectProperty("EsConcepto", gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto, false, false);
   }

   public String getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo ;
   }

   public void setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo( String value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo = value ;
   }

   public boolean getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido ;
   }

   public void setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( boolean value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip ;
   }

   public void setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip( String value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip = value ;
   }

   public boolean getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible ;
   }

   public void setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible( boolean value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible = value ;
   }

   public short getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo ;
   }

   public void setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo( short value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo = value ;
   }

   public boolean getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto ;
   }

   public void setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto( boolean value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo = "" ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N ;
   }

   public web.Sdtsdt_conceptos_sdt_conceptosItem Clone( )
   {
      return (web.Sdtsdt_conceptos_sdt_conceptosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_conceptos_sdt_conceptosItem struct )
   {
      setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo(struct.getConcodigo());
      setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido(struct.getYarecorrido());
      setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip(struct.getCondescrip());
      setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible(struct.getEsimprimible());
      setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo(struct.getDirecto());
      setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto(struct.getEsconcepto());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_conceptos_sdt_conceptosItem getStruct( )
   {
      web.StructSdtsdt_conceptos_sdt_conceptosItem struct = new web.StructSdtsdt_conceptos_sdt_conceptosItem ();
      struct.setConcodigo(getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo());
      struct.setYarecorrido(getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido());
      struct.setCondescrip(getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip());
      struct.setEsimprimible(getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible());
      struct.setDirecto(getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo());
      struct.setEsconcepto(getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N ;
   protected short gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido ;
   protected boolean gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible ;
   protected boolean gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip ;
}

